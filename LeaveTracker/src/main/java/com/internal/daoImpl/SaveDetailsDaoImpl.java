package com.internal.daoImpl;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.internal.dao.SaveDetailsDao;
import com.internal.entity.EQEmployeeRole;
import com.internal.entity.EQLeaveType;
import com.internal.entity.EQTeam;
import com.internal.entity.EQVMDetails;

@Repository
public class SaveDetailsDaoImpl implements SaveDetailsDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	// getting the Session Factory
	public Session getSession() {
		return this.entityManagerFactory.unwrap(SessionFactory.class).getCurrentSession();
	}

	@Override
	public String saveRole() {
		return null;
	}

	@Override
	public String saveVm() {
		return null;
	}

	@Override
	public String saveLeaveType() {
		return null;
	}

	@Override
	public String saveTeam() {
		EQVMDetails vmDetails = new EQVMDetails("GRVMDEVWKSA690", "170.27.65.120");
		EQVMDetails vmDetails1 = new EQVMDetails("GRVMDEVWKSA690", "170.27.65.121");
		EQVMDetails vmDetails2 = new EQVMDetails("GRVMDEVWKSA690", "170.27.65.122");
		EQVMDetails vmDetails3 = new EQVMDetails("GRVMDEVWKSA690", "170.27.65.123");
		EQVMDetails vmDetails4 = new EQVMDetails("GRVMDEVWKSA690", "170.27.65.124");
		EQVMDetails vmDetails5 = new EQVMDetails("GRVMDEVWKSA690", "170.27.65.125");
		EQTeam team = new EQTeam("EQ - Xanite - DEV");
		EQTeam team1 = new EQTeam("EQ - Xanite - QA");
		EQEmployeeRole role = new EQEmployeeRole("Manager");
		EQEmployeeRole role1 = new EQEmployeeRole("Software Engineer");
		EQEmployeeRole role2 = new EQEmployeeRole("Senior Software Engineer");
		EQEmployeeRole role3 = new EQEmployeeRole("Team Lead");
		EQLeaveType leave = new EQLeaveType("Casual Leave");
		EQLeaveType leave1 = new EQLeaveType("Planned Leave");
		EQLeaveType leave2 = new EQLeaveType("Sick Leave");
		EQLeaveType leave3 = new EQLeaveType("Optional Holiday");
		EQLeaveType leave4 = new EQLeaveType("UK Holiday");
		EQLeaveType leave5 = new EQLeaveType("Permission -1");
		EQLeaveType leave6 = new EQLeaveType("Permission -2");
		getSession().save(leave);
		getSession().save(leave1);
		getSession().save(leave2);
		getSession().save(leave3);
		getSession().save(leave4);
		getSession().save(leave5);
		getSession().save(leave6);
		getSession().save(team);
		getSession().save(team1);
		getSession().save(role);
		getSession().save(role1);
		getSession().save(role2);
		getSession().save(role3);
		getSession().save(vmDetails);
		getSession().save(vmDetails1);
		getSession().save(vmDetails2);
		getSession().save(vmDetails3);
		getSession().save(vmDetails4);
		getSession().save(vmDetails5);
		return "Success";
	}

}
