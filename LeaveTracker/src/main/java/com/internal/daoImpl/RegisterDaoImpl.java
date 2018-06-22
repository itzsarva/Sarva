package com.internal.daoImpl;

import java.util.List;
import java.util.Optional;

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
		String message = null;
		try {
			getSession().save(arg0);
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
	@Override
	public Optional<EQEmployee> findObject(Long arg0) {
		return null;
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

}
