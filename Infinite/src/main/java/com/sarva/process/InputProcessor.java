package com.sarva.process;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sarva.entity.EmployeeDetail;
import com.sarva.service.GatherinfoService;

@Component
public class InputProcessor {

	@Autowired
	private GatherinfoService service;

	/*
	 * Hit the Service and fetch the results.
	 */
	public List<EmployeeDetail> doProcess(String... strArray) {
		List<EmployeeDetail> listOfEmployee = null;
		String[] strObtained = strArray;
		if (!strObtained[0].equalsIgnoreCase("how") && !strObtained[0].equalsIgnoreCase("new")
				&& !strObtained[0].equalsIgnoreCase("the") && !strObtained[0].equalsIgnoreCase("all")) {
			return listOfEmployee = service.getSingleNameAndOther(strObtained);
		}
		return listOfEmployee;
	}

	public List<EmployeeDetail> getMonths(List<EmployeeDetail> empDetail, String[] valuesObtained) {
		empDetail = service.getMonths(valuesObtained);
		return empDetail;

	}

	public List<EmployeeDetail> doProcessTimePeriod(List<EmployeeDetail> empDetail, String[] valuesObtained) {
		empDetail = service.getTimePeriod(valuesObtained);
		return empDetail;

	}

	/* to process an individual employee and get the results */
	public String doSingleProcess(List<EmployeeDetail> value, String[] valuesObtained) {
		EmployeeDetail empDetail = value.get(0);
		String[] values = valuesObtained;
		String requiredValue = values[1];
		Date currentDate = new Date();
		if (requiredValue.equalsIgnoreCase("empid")) {
			return "His Employee Id is  " + empDetail.getEmpId();
		} else if (requiredValue.equalsIgnoreCase("designation")) {
			return "His Designation is  " + empDetail.getDesignation();
		} else if (requiredValue.equalsIgnoreCase("emailId")) {
			return "His email Id  is  " + empDetail.getEmailId();
		} else if (requiredValue.equalsIgnoreCase("project")) {
			return "His Project is  " + empDetail.getProject();
		} else if (requiredValue.equalsIgnoreCase("doj")) {
			return "His Date of Joining is  " + empDetail.getdOJ();
		} else if (requiredValue.equalsIgnoreCase("dol")) {
			return "His Date of Leaving is  " + empDetail.getdOL();
		} else if (requiredValue.equalsIgnoreCase("Experience")) {
			Long yearsOfExperience = getDateDiff(currentDate, empDetail.getdOJ(), TimeUnit.DAYS);
			return "His yearsOfExperience is  " + yearsOfExperience;
		}
		return "";
	}

	// to calculate years of Experience
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.DAYS);
	}

	public List<EmployeeDetail> getBetween(List<EmployeeDetail> empDetail, String[] valuesObtained) {
		empDetail = service.getBetween(valuesObtained);
		return empDetail;
	}

	public String getCount(String[] valuesObtained) {
		Long count = service.getCount(valuesObtained);
		return "The Count is = " + count;
	}

}
