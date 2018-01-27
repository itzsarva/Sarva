package com.sarva.jersey;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import com.sarva.dto.ProfileDTO;
import com.sarva.entity.Profile;
import com.sarva.exception.CommonHandling;
import com.sarva.exception.MancsNotAllowedException;
import com.sarva.exception.ProfileNotFoundException;
import com.sarva.paramConverters.Details;
import com.sarva.service.ProfilesDAO;

@Path("/profiles")
public class Profiles {

	@Autowired
	private ProfilesDAO profilesDAO;

	@Autowired
	private MessageResource resource;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProfileDTO> getAllProfiles(@Context UriInfo uri) {
		return profilesDAO.getAllProfiles(uri);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam(value = "id") Integer id) throws CommonHandling {
		System.err.println("coming inside getMethod");
		Profile profile = profilesDAO.getProfile(id);
		if (null == profile) {
			throw new ProfileNotFoundException("the requested resource for the id = " + id + "is not found");
		}
		return profile;
	}

	@POST
	@Path("/addProfile")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProfile(Profile profile, @Context UriInfo uri) {
		if (profile.getName().equalsIgnoreCase("manchester")) {
			throw new MancsNotAllowedException("Yo not here man, somewhere else!!");
		}
		URI url = uri.getAbsolutePathBuilder().path(profilesDAO.addProfile(profile).toString()).build();
		return Response.created(url).build();
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteProfile(@PathParam(value = "id") Integer id) throws CommonHandling {
		System.err.println("coming inside deleteMethod");
		if (id == 9) {
			throw new CommonHandling("Common exception has occured");
		}
		return profilesDAO.deleteProfile(id);
	}

	@Path("/{profileID}/messages")
	public MessageResource getMessageResource() {
		return resource;
	}

	@GET
	@Path("/param/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetails(@PathParam("value") Details details) {
		return Response.status(Status.ACCEPTED).entity(details).build();
	}

	@GET
	@Path("/body")
	@Produces(MediaType.APPLICATION_JSON)
	public Map getBody() {
		System.err.println("coming inside this method");
		HashMap<String, String> mapp = new HashMap<>();
		mapp.put("kiss", "And tell");
		mapp.put("kis", "And tell");
		return mapp;
	}

	@GET
	@Path("csv/{id}")
	@Produces("application/csv")
	public Profile getProfileCsv(@PathParam(value = "id") Integer id) throws CommonHandling {
		System.err.println("coming inside getMethod");
		Profile profile = profilesDAO.getProfile(id);
		return profile;
	}

}
