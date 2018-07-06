package com.internal.reportgen;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class TimeSheetGeneratorPOI {

	final static Properties prop = new Properties();

	// This will help to find how many days to be deducted to reach Monday from the
	// day on which the report is run
	final static Map<String, Integer> daysToMinus = new HashMap<String, Integer>();
	static {
		daysToMinus.put("Monday", 0);
		daysToMinus.put("Tuesday", 1);
		daysToMinus.put("Wednesday", 2);
		daysToMinus.put("Thursday", 3);
		daysToMinus.put("Friday", 4);
		daysToMinus.put("Saturday", 5);
		daysToMinus.put("Sunday", 6);
	}

	public void generateReport() throws ParseException, IOException, InvalidFormatException {

		TimeSheetGeneratorPOI timeSheet = new TimeSheetGeneratorPOI();

		InputStream input = null;
		String prop_file = "configuration\\application.properties";

		input = new FileInputStream(prop_file);
		prop.load(input);

		File _inputWorkbook = new File(prop.getProperty("inputLeaveTracker"));

		List<Employee> _leaveCollection;

		if (_inputWorkbook.exists()) {
			_leaveCollection = timeSheet.readAttendenceForWeek(_inputWorkbook);
			if (_leaveCollection != null) {
				System.out.println("TimeSheet to be filled for : " + _leaveCollection.size() + " resources");
				prepareTimesheet(_leaveCollection);
			} else {
				System.err.println("No details found!");
			}
		} else {
			System.err.println("Leave Tracker File is missing!");
		}

	}

	/**
	 * 
	 * @param inputTrackerFile
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 * @throws InvalidFormatException
	 */
	public List<Employee> readAttendenceForWeek(File inputTrackerFile)
			throws IOException, ParseException, InvalidFormatException {

		Workbook _wBook;
		int _totalEmployees;

		_wBook = new XSSFWorkbook();
		Sheet sheet = _wBook.getSheet("Daily_Tracker");

		_totalEmployees = (int) sheet.getRow(0).getCell(2).getNumericCellValue();

		List<Employee> empAttendenceList = new ArrayList<>();

		for (int col = 4; col < _totalEmployees + 4; col++) {
			Employee emp = new Employee();
			for (int row = 3; row < sheet.getLastRowNum(); row++) {

				Date _currentDateCell = sheet.getRow(row).getCell(2).getDateCellValue();

				if (isCurrentDay(_currentDateCell)) {
					String _currentDay = sheet.getRow(row).getCell(3).getStringCellValue();
					int _newRowStart = daysToMinus.get(_currentDay);

					emp.setEmpId((int) sheet.getRow(1).getCell(col).getNumericCellValue());

					boolean flag = true;
					if (sheet.getRow(2).getCell(col).getStringCellValue().trim().equalsIgnoreCase("Non-Prod")) {
						flag = false;
					}
					emp.setProductiveResource(flag);

					LinkedHashMap<String, String> leaveDetailsWeekly = new LinkedHashMap<>();

					for (int i = row - _newRowStart; i <= row; i++) {
						if (!isWeekend(sheet.getRow(i).getCell(3).getStringCellValue())) {
							leaveDetailsWeekly.put(dateAsString(sheet.getRow(i).getCell(2).getDateCellValue()),
									sheet.getRow(i).getCell(col).getStringCellValue());
						}

					}
					emp.setAttendenceInformation(leaveDetailsWeekly);
				}
			}
			empAttendenceList.add(emp);
		}
		_wBook.close();

		return empAttendenceList;

	}

	private String dateAsString(Date dateCellValue) {
		return new SimpleDateFormat("dd-MMM").format(dateCellValue);
	}

	/**
	 * Method to check if the current day has been reached in the Leave Tracker
	 * 
	 * @param dateFromSheet
	 * @return
	 * @throws ParseException
	 */
	private boolean isCurrentDay(Date dateFromSheet) throws ParseException {
		Date _today = new SimpleDateFormat("dd-MMM").parse(new SimpleDateFormat("dd-MMM").format(new Date()));
		Date _dateFromSheet = new SimpleDateFormat("dd-MMM")
				.parse(new SimpleDateFormat("dd-MMM").format(dateFromSheet));
		return _today.equals(_dateFromSheet);
	}

	/**
	 * @param day
	 * @return
	 */
	private boolean isWeekend(String day) {
		return "Saturday".equalsIgnoreCase(day) || "Sunday".equalsIgnoreCase(day);
	}

	/**
	 * This will copy the template file into a new file and populate the holiday /
	 * permission details. And then, it will calculate the productive hours using
	 * the formula Productive Hours = Configured effective hours - Holidays -
	 * Meetings - Non Project Efforts
	 * 
	 * @param empDetailsList
	 * @throws IOException
	 * @throws ParseException
	 */
	private static void prepareTimesheet(List<Employee> empDetailsList) throws IOException, ParseException {

		Workbook copybook = null;
		SimpleDateFormat formatter = new SimpleDateFormat(prop.getProperty("fileNameDateFormat"));
		String _today = formatter.format(new Date());
		boolean sendToManager = Boolean.valueOf(prop.getProperty("sendToManager"));
		String prefix = sendToManager ? prop.getProperty("managerOutputLocation")
				: prop.getProperty("reportOutputLocation");
		String _reportName = prefix + prop.getProperty("timeSheetReportName") + " - " + _today + ".xlsx";
		String _weekStartDate = null;
		int _totalDays = 0;
		boolean _isFirstTime = true;

		Map<String, Object> properties = new HashMap<>();

		// create property set for vertical borders
		properties.put(CellUtil.BORDER_LEFT, BorderStyle.THIN);
		properties.put(CellUtil.BORDER_RIGHT, BorderStyle.THIN);
		properties.put(CellUtil.BORDER_BOTTOM, BorderStyle.THIN);
		properties.put(CellUtil.BORDER_TOP, BorderStyle.THIN);
		properties.put(CellUtil.ALIGNMENT, HorizontalAlignment.CENTER);

		try {

			Path _reportTemplate = Paths.get(prop.getProperty("templateTimesheet"));
			Path _tempFile = Paths.get(prop.getProperty("templateTimesheetTemp"));

			if (!_reportTemplate.toFile().exists()) {
				System.err.println("Timesheet Template is missing!");
				System.exit(1);
			}
			Files.copy(_reportTemplate, _tempFile, StandardCopyOption.REPLACE_EXISTING);

			copybook = new XSSFWorkbook(new FileInputStream(prop.getProperty("templateTimesheetTemp")));

			Sheet copysheet = copybook.getSheetAt(0);

			for (Employee _emp : empDetailsList) {
				for (int row = 4; row <= copysheet.getLastRowNum(); row++) {
					Integer reportEmpId = (int) copysheet.getRow(row).getCell(0).getNumericCellValue();
					if (reportEmpId.equals(_emp.getEmpId())) {
						System.err.println("Placing the holiday entries for " + _emp.getEmpId());
						int idx = 0;
						for (String currentKey : _emp.getAttendenceInformation().keySet()) {
							String _dayInfo = _emp.getAttendenceInformation().get(currentKey);
							if (!isBlank(_dayInfo)) {
								Cell cell = copysheet.getRow(row).createCell(idx + 14);
								cell.setCellValue(getEntryForDay(_dayInfo));
								CellUtil.setCellStyleProperties(cell, properties);
								cell.setCellType(CellType.NUMERIC);
							}

							// Store the first day of the week
							if (_isFirstTime) {
								_weekStartDate = currentKey;
								_totalDays = _emp.getAttendenceInformation().entrySet().size();
								_isFirstTime = false;

							}
							idx++;
						}

						System.err.println("Placing the productive hours / non project entries for " + _emp.getEmpId());
						// Fill the Productive Hours for productive resources
						// It's 7.5 Hours minus holidays, meetings and non project efforts
						// For the non-productive employees, effort would go into non projects sections
						// minus holidays
						for (int col = 4; col < 4 + _totalDays; col++) {
							boolean isProductive = _emp.isProductiveResource();
							StringBuilder str_formula = new StringBuilder("SUM(");
							str_formula.append(prop.getProperty("effectiveHoursPerDay"));
							// Holidays
							str_formula.append(deductHours(copysheet.getRow(row).getCell(col + 10)));
							if (isProductive) {
								// Meetings
								str_formula.append(deductHours(copysheet.getRow(row).getCell(col + 5)));
								// Non-Projects
								str_formula.append(deductHours(copysheet.getRow(row).getCell(col + 15)));
							}
							str_formula.append(")");

							Cell cell = copysheet.getRow(row).createCell(isProductive ? col : col + 15);
							cell.setCellType(CellType.FORMULA);
							cell.setCellFormula(str_formula.toString());
							CellUtil.setCellStyleProperties(cell, properties);
						}

					}
				}
			}

			CreationHelper createHelper = copybook.getCreationHelper();

			// Update the dates
			CellStyle st = copysheet.getRow(3).getCell(4).getCellStyle();
			st.setDataFormat(createHelper.createDataFormat().getFormat("d-mmm"));
			Cell cell = copysheet.getRow(3).createCell(4);
			cell.setCellValue(_weekStartDate);
			cell.setCellStyle(st);

			createHelper.createFormulaEvaluator().evaluateAll();
			copybook.setForceFormulaRecalculation(true);

			copybook.write(new FileOutputStream(prop.getProperty("templateTimesheetTemp")));
			copybook.close();

			Path _reportFile = Paths.get(_reportName);

			Files.move(_tempFile, _reportFile, StandardCopyOption.REPLACE_EXISTING);

			if (Desktop.isDesktopSupported() && !sendToManager) {
				System.out.println("Opening the Report File!");
				Desktop.getDesktop().open(_reportFile.toFile());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String deductHours(Cell cell) {
		if (cell.getCellTypeEnum() == CellType.NUMERIC) {
			return "-" + cell.getNumericCellValue();
		}
		return "";
	}

	/**
	 * @param entryFromLeaveTracker
	 * @param prop
	 * @return
	 */
	private static double getEntryForDay(String entryFromLeaveTracker) {

		String _returnString = "";
		if (Pattern.matches("\\d", String.valueOf(entryFromLeaveTracker.charAt(0)))) {
			_returnString = String.valueOf(entryFromLeaveTracker.charAt(0));
		} else if (entryFromLeaveTracker.contains("Half")) {
			_returnString = prop.getProperty("effectiveHoursPerHalfDay");
		} else {
			_returnString = prop.getProperty("effectiveHoursPerDay");
		}

		return Double.parseDouble(_returnString);
	}

	/**
	 * @param string
	 * @return
	 */
	private static boolean isBlank(String string) {
		if (string == null || "".equalsIgnoreCase(string.trim()))
			return true;
		return false;
	}

}