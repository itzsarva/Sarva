package com.sarva.service;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sarva.dto.ProfileDTO;
import com.sarva.entity.Profile;

@Service
@Transactional
public class ProfilesDAOImpl implements ProfilesDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<ProfileDTO> getAllProfiles(UriInfo uri) {
		Session session = getSession();
		session.beginTransaction();
		Query query;
		Integer start = null;
		Integer max = null;
		MultivaluedMap<String, String> queryParams = uri.getQueryParameters();
		if (null != queryParams && !queryParams.isEmpty()) {
			start = Integer.parseInt(queryParams.getFirst("start"));
			max = Integer.parseInt(queryParams.getFirst("max"));
		}
		if (null != max && null != start) {
			query = session.createQuery("from Profile").setFirstResult(start).setMaxResults(max);
		} else {
			query = session.createQuery("from Profile");
		}
		List<ProfileDTO> profileList = (List<ProfileDTO>) query.list();
		session.beginTransaction().commit();
		return profileList;
	}

	@Override
	public Profile getProfile(Integer id) {
		Session session = getSession();
		session.beginTransaction();
		Profile profileDTO = (Profile) session.get(Profile.class, id);
		session.beginTransaction().commit();
		return profileDTO;
	}

	@Override
	public Integer addProfile(Profile profile) {
		Session session = getSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(profile);
		session.beginTransaction().commit();
		return id;
	}

	@Override
	public String deleteProfile(Integer id) {
		Session session = getSession();
		session.beginTransaction();
		Profile profile = (Profile) session.get(Profile.class, id);
		session.delete(profile);
		session.beginTransaction().commit();
		return "successfully deleted";
	}

}
