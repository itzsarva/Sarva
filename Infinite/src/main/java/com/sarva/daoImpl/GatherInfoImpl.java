package com.sarva.daoImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sarva.dao.GatherInfoDAO;
import com.sarva.entity.EmployeeDetail;
import com.sarva.entity.EmployeeProjectMapping;
import com.sarva.entity.LookBussinessUnit;
import com.sarva.entity.TeamProjectMapping;

@Repository
@Transactional
public class GatherInfoImpl implements GatherInfoDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Session getSession() {
		return this.entityManagerFactory.unwrap(SessionFactory.class).getCurrentSession();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<EmployeeDetail> getSingleNameAndOther(String... strings) {
		String[] str = strings;
		Query<EmployeeDetail> query = null;
		Session session = getSession();
		query = session.createQuery("select e from EmployeeDetail e where empName like :nameValue");
		query.setParameter("nameValue", str[0] + "%");
		return query.getResultList();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<EmployeeDetail> getTimePeriod(String[] valuesObtained) {
		String[] str = valuesObtained;
		Criteria criteria = null;
		Session session = getSession();
		int year = getYear(str);
		Calendar cal = Calendar.getInstance();
		int thisYear = cal.get(Calendar.YEAR);
		int lastYear = thisYear - 1;
		if (str[1].contains("Leavers")) {
			if (str[0].equalsIgnoreCase("this")) {
				criteria = session.createCriteria(EmployeeDetail.class);
				if (str[1].equalsIgnoreCase("year")) {
					criteria.add(Restrictions.sqlRestriction("to_char(dol, 'yyyy') = ?", new Object[] { year + "" },
							new Type[] { StandardBasicTypes.STRING }));
				}
				if (str[1].equalsIgnoreCase("month")) {
					criteria.add(Restrictions.sqlRestriction("to_char(dol, 'mm') = ?", new Object[] { year + "" },
							new Type[] { StandardBasicTypes.STRING }));
					criteria.add(Restrictions.sqlRestriction("to_char(dol, 'yyyy') = ?", new Object[] { thisYear + "" },
							new Type[] { StandardBasicTypes.STRING }));
				}
			}
			if (str[0].equalsIgnoreCase("last")) {
				if (str[1].equalsIgnoreCase("year")) {
					criteria.add(Restrictions.sqlRestriction("to_char(dol, 'yyyy') = ?", new Object[] { year + "" },
							new Type[] { StandardBasicTypes.STRING }));
				}
				if (str[1].equalsIgnoreCase("month")) {
					criteria.add(Restrictions.sqlRestriction("to_char(dol, 'mm') = ?", new Object[] { year + "" },
							new Type[] { StandardBasicTypes.STRING }));
					criteria.add(Restrictions.sqlRestriction("to_char(dol, 'yyyy') = ?", new Object[] { lastYear + "" },
							new Type[] { StandardBasicTypes.STRING }));
				}
			}
		} else {
			if (str[0].equalsIgnoreCase("this")) {
				criteria = session.createCriteria(EmployeeDetail.class);
				if (str[1].equalsIgnoreCase("year")) {
					criteria.add(Restrictions.sqlRestriction("to_char(doj, 'yyyy') = ?", new Object[] { year + "" },
							new Type[] { StandardBasicTypes.STRING }));
				}
				if (str[1].equalsIgnoreCase("month")) {
					criteria.add(Restrictions.sqlRestriction("to_char(doj, 'mm') = ?", new Object[] { year + "" },
							new Type[] { StandardBasicTypes.STRING }));
					criteria.add(Restrictions.sqlRestriction("to_char(doj, 'yyyy') = ?", new Object[] { thisYear + "" },
							new Type[] { StandardBasicTypes.STRING }));
				}
			}
			if (str[0].equalsIgnoreCase("last")) {
				if (str[1].equalsIgnoreCase("year")) {
					criteria.add(Restrictions.sqlRestriction("to_char(doj, 'yyyy') = ?", new Object[] { year + "" },
							new Type[] { StandardBasicTypes.STRING }));
				}
				if (str[1].equalsIgnoreCase("month")) {
					criteria.add(Restrictions.sqlRestriction("to_char(doj, 'mm') = ?", new Object[] { year + "" },
							new Type[] { StandardBasicTypes.STRING }));
					criteria.add(Restrictions.sqlRestriction("to_char(doj, 'yyyy') = ?", new Object[] { lastYear + "" },
							new Type[] { StandardBasicTypes.STRING }));
				}
			}
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeDetail> getMonths(String[] valuesObtained) {
		String[] str = valuesObtained;
		Session session = getSession();
		Query<EmployeeDetail> query = null;
		Date fromDate = getDateDifference(valuesObtained);
		Date toDate = Calendar.getInstance().getTime();
		if (str[2].contains("Leavers")) {
			query = session.createQuery("select e from EmployeeDetail e where dol between :from and :to")
					.setParameter("from", fromDate).setParameter("to", toDate);
		} else {
			query = session.createQuery("select e from EmployeeDetail e where doj between :from and :to")
					.setParameter("from", fromDate).setParameter("to", toDate);
		}
		return query.getResultList();
	}

	private int getYear(String[] str) {
		Calendar cal = Calendar.getInstance();
		int thisMonth = cal.get(Calendar.MONTH);
		int thisYear = cal.get(Calendar.YEAR);
		int lastMonth = thisMonth - 1;
		int lastYear = thisYear - 1;
		String[] value = str;
		String first = value[0];
		String second = value[1];
		if (first.equalsIgnoreCase("this")) {
			if (second.equalsIgnoreCase("year")) {
				return thisYear;
			} else {
				return thisMonth;
			}
		} else {
			if (second.equalsIgnoreCase("year")) {
				return lastYear;
			} else {
				return lastMonth;
			}
		}
	}

	public static Date getDateDifference(String[] valuesObtained) {
		String[] values = valuesObtained;
		int value = Integer.parseInt(values[1]);
		int month = value * -1;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, month);
		Date date = cal.getTime();
		return date;
	}

	// Joiners send me joiners between Jan 2015 and Jan 2017.
	public int getExactMonth(String val) {
		String value = val;
		int getMonth = 0;
		switch (value) {
		case "Jan":
			getMonth = Calendar.JANUARY;
			break;
		case "Feb":
			getMonth = Calendar.FEBRUARY;
			break;
		case "Mar":
			getMonth = Calendar.MARCH;
			break;
		case "Apr":
			getMonth = Calendar.APRIL;
			break;
		case "May":
			getMonth = Calendar.MAY;
			break;
		case "Jun":
			getMonth = Calendar.JUNE;
			break;
		case "Jul":
			getMonth = Calendar.JULY;
			break;
		case "Aug":
			getMonth = Calendar.AUGUST;
			break;
		case "Sep":
			getMonth = Calendar.SEPTEMBER;
			break;
		case "Oct":
			getMonth = Calendar.OCTOBER;
			break;
		case "Nov":
			getMonth = Calendar.NOVEMBER;
			break;
		case "Dec":
			getMonth = Calendar.DECEMBER;
			break;
		}
		return getMonth;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void addObject() {

		EmployeeProjectMapping empMapping = new EmployeeProjectMapping(1001l, "Sarva", new Date("10/01/2018"), "Sarva",
				new Date("10/01/2018"));

		EmployeeDetail detail = new EmployeeDetail(2034l, "itz@gmail.com", "sarva", new Date("10/01/2018"),
				new Date("10/12/2018"), "SomeProject", "idk", "Active", 7000000l, 3003311l, "tingding", "Yes");

		TeamProjectMapping teamMapping = new TeamProjectMapping(1111l, "Some", "No", new Date("10/01/2018"), "idk",
				"sarva", new Date("10/01/2018"), "Sarva", "Name");

		empMapping.setEmpDetail(detail);
		empMapping.setTeamProjMapping(teamMapping);
		LookBussinessUnit unit = new LookBussinessUnit(1l, "Equiniti");
		unit.getDetail().add(detail);
		unit.getTeamMapping().add(teamMapping);
		detail.setbUnit(unit);
		detail.getEmpMapping().add(empMapping);
		teamMapping.getEmpProjMapping().add(empMapping);
		teamMapping.setbUnit(unit);

		// saving the session
		Session session = getSession();
		session.save(unit);

	}

	// Tell me joiners between Jan 2014 and Jan 2015
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeDetail> getBetween(String[] valuesObtained) {
		Session session = getSession();
		Query<EmployeeDetail> query = null;
		String[] str = valuesObtained;
		String fromMonthString = str[0];
		String fromYearString = str[1];
		String toMonthString = str[3];
		String toYearString = str[4];
		int fromMonth = getExactMonth(fromMonthString);
		int toMonth = getExactMonth(toMonthString);
		int fromYear = Integer.parseInt(fromYearString);
		int toYear = Integer.parseInt(toYearString);
		Date fromDate = getFromDate(fromMonth, fromYear);
		Date toDate = getFromDate(toMonth, toYear);
		if (str[2].contains("Leavers")) {
			query = session.createQuery("select e from EmployeeDetail e where dol between :from and :to")
					.setParameter("from", fromDate).setParameter("to", toDate);
		} else {
			query = session.createQuery("select e from EmployeeDetail e where doj between :from and :to")
					.setParameter("from", fromDate).setParameter("to", toDate);
		}
		return query.getResultList();
	}

	private Date getFromDate(int Month, int Year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Month);
		cal.set(Calendar.YEAR, Year);
		return cal.getTime();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long getCount(String[] valuesObtained) {
		String designation = valuesObtained[0];
		Session session = getSession();
		Query<Long> query = null;
		query = session.createQuery("select count(e) from EmployeeDetail e where designation = :designation")
				.setParameter("designation", designation);
		return query.uniqueResult();
	}

}