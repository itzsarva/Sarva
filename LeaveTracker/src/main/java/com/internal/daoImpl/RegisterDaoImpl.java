package com.internal.daoImpl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.internal.dao.RegisterDao;
import com.internal.entity.EQEmployee;
import com.internal.entity.EQEmployeeRole;
import com.internal.entity.EQTeam;
import com.internal.entity.EQVMDetails;

/**
 * @author ravis3
 *
 */
@Repository
public class RegisterDaoImpl implements RegisterDao {

	/**
	 * 
	 */
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	// getting the Session Factory
	public Session getSession() {
		return this.entityManagerFactory.unwrap(SessionFactory.class).getCurrentSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.internal.dao.RegisterDao#deleteById(java.lang.Long)
	 */
	@Override
	public void deleteById(Long arg0) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.internal.dao.RegisterDao#save(com.internal.entity.EQEmployee)
	 */
	@Override
	public String save(EQEmployee arg0) {
		System.err.println(arg0.getEmployeeId());
		String message = null;
		try {
			getSession().saveOrUpdate(arg0);
			message = "Success";
		} catch (Exception e) {
			message = "error";
		}
		return message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.internal.dao.RegisterDao#findById(java.lang.Long)
	 */
	@Override
	public boolean findById(Long arg0) {
		EQEmployee employee = getSession().find(EQEmployee.class, arg0);
		if (null != employee) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.internal.dao.RegisterDao#findObject(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EQEmployee findObject(Long empId) {
		Query<EQEmployee> query = null;
		query = getSession().createQuery("from EQEmployee where employeeId = :empId");
		query.setParameter("empId", empId);
		return query.getSingleResult();
	}

	/*
	 * (non-Javadoc) To get all the team present in the database to load the
	 * respective drop down
	 * 
	 * @see com.internal.dao.RegisterDao#getTeam()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EQTeam> getTeam(String description) {
		Query<EQTeam> query = null;
		if (null == description) {
			query = getSession().createNamedQuery("@HQL_GET_ALL_EQTEAM");
			return query.list();
		} else {
			query = getSession().createQuery("from EQTeam where description = :des");
			query.setParameter("des", description);
			return query.list();
		}
	}

	/*
	 * (non-Javadoc) To get all the VM present in the database to load the
	 * respective drop down
	 * 
	 * @see com.internal.dao.RegisterDao#getVM()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EQVMDetails> getVM(String description) {
		Query<EQVMDetails> query = null;
		if (null == description) {
			query = getSession().createNamedQuery("@HQL_GET_ALL_EQVMDETAILS");
			return query.list();
		} else {
			query = getSession().createQuery("from EQVMDetails where ip = :des");
			query.setParameter("des", description);
			return query.list();
		}
	}

	/*
	 * (non-Javadoc) To get all the roles present in the database to load the
	 * respective drop down
	 * 
	 * @see com.internal.dao.RegisterDao#getRoles()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EQEmployeeRole> getRoles(String description) {
		Query<EQEmployeeRole> query = null;
		if (null == description) {
			query = getSession().createNamedQuery("@HQL_GET_ALL_EMPLOYEEROLE");
			return query.list();
		} else {
			query = getSession().createQuery("from EQEmployeeRole where description = :des");
			query.setParameter("des", description);
			return query.list();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getTeamDescriptionById(Long id) {
		Query<String> query = null;
		query = getSession().createQuery("select description from EQTeam where teamId = :id");
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getVmDescriptionById(Long id) {
		Query<String> query = null;
		query = getSession().createQuery("select ip from EQVMDetails where vmId = :id");
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getRoleDescriptionbyId(Long id) {
		Query<String> query = null;
		query = getSession().createQuery("select description from EQEmployeeRole where roleId = :id");
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public void removeLockOnVM(Long id) {
		EQEmployee employee = getSession().find(EQEmployee.class, id);
		if (null != employee.getVm()) {
			Long getVmId = employee.getVm().getVmId();
			EQVMDetails vmDetails = getSession().find(EQVMDetails.class, getVmId);
			vmDetails.setIsAssigned("N");
			getSession().update(vmDetails);
		}
	}

	@Override
	public void removeReference(Long id) {
		EQEmployee employee = getSession().find(EQEmployee.class, id);
		employee.setVm(null);
		getSession().saveOrUpdate(employee);
	}

}
