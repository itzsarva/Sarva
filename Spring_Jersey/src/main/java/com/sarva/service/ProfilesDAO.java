package com.sarva.service;

import java.util.List;

import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Component;

import com.sarva.dto.ProfileDTO;
import com.sarva.entity.Profile;

@Component
public interface ProfilesDAO {

	public List<ProfileDTO> getAllProfiles(UriInfo uri);

	public Profile getProfile(Integer id);

	public Integer addProfile(Profile profile);

	public String deleteProfile(Integer id);
}
