package com.sarva.controller;

import java.util.List;

import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarva.dto.ProfileDTO;
import com.sarva.service.ProfilesDAO;

@RestController
public class Profiles {

	@Autowired
	private ProfilesDAO profilesDAO;

	@RequestMapping(value = "/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProfileDTO> getAllProfiles(UriInfo info) {
		return profilesDAO.getAllProfiles(info);
	}

}
