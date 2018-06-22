package com.internal.daoImpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.internal.dao.TimeSheetDao;
import com.internal.entity.EQLeaveType;
import com.internal.entity.EQTimeSheetDetails;

@Repository
public class TimeSheetDaoImpl implements TimeSheetDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	// getting the Session Factory
	public Session getSession() {
		return this.entityManagerFactory.unwrap(SessionFactory.class).getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public String getUserName(String name) {
		Query<String> query = null;
		query = getSession().createQuery("select firstName from EQEmployee where Employeeid = :userName");
		query.setParameter("userName", new Long(name));
		return query.getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.internal.dao.RegisterDao#getLeaveType()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EQLeaveType> getLeaveType(String description) {
		Query<EQLeaveType> query = null;
		if (null == description) {
			query = getSession().createNamedQuery("@HQL_GET_ALL_EMPLOYE_LEAVETYPE");
			return query.list();
		} else {
			query = getSession().createQuery("from EQLeaveType where description = :des");
			query.setParameter("des", description);
			return query.list();
		}
	}

	@Override
	public String saveLeaves(List<EQTimeSheetDetails> timesheet) {
		timesheet.forEach(System.out::println);
		Session session = getSession();
		timesheet.forEach(obj -> session.saveOrUpdate((obj)));
		return "success";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getRecordsFromDate(Date startDate, Date endDate, Long userId) {
		System.err.println(startDate);
		System.err.println(endDate);
		System.err.println(userId);
		Query<String> query = null;
		if (null == endDate) {
			query = getSession().createQuery(
					"select leave.description from EQTimeSheetDetails emp INNER JOIN emp.leaveType leave where emp.empPrimary.attendanceDate = :startDate and emp.empPrimary.employeeId = :userId order by emp.empPrimary.attendanceDate");
			query.setParameter("startDate", startDate);
			query.setParameter("userId", userId);
			return query.getResultList();
		} else {
			query = getSession().createQuery(
					"select leave.description from EQTimeSheetDetails emp INNER JOIN emp.leaveType leave where emp.empPrimary.attendanceDate between :startDate and :endDate and emp.empPrimary.employeeId = :userId order by emp.empPrimary.attendanceDate");
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			query.setParameter("userId", userId);
			return query.getResultList();
		}
	}

}
