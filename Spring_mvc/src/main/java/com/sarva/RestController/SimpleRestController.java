package com.sarva.RestController;

import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/simpleRest")
public class SimpleRestController {

	@RequestMapping(value = "/simpleRest", method = RequestMethod.GET)
	public String some() {
		return "some String";
	}

	@RequestMapping(value = "/simpleRest1", method = RequestMethod.GET)
	public String some1() {
		return "some String";
	}

	// Designing the URLs for the RestFul webservices:
	// 1. get request: say if you are getting the all the users in your firm:

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getAllUsers() {
		return "";
	}

	// 2. when you want to get a particular user:
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String getUser(@PathParam("id") String id) {
		return "";
	}

	// 3. when you have to get apply any range use query params
	// say if the request is /users/21?place=coimbaotre&offset=10&range=10
	// so this request will return users from coimbatore and those who are
	// between
	// 10 and 20
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getRangeOfUsers(@RequestParam Map<String, String> range) {
		return "";
	}

	// 4. relational urls ,
	// say if you have details of user like addresses and occupation then
	// you specify the urls in relation to the users.
	@RequestMapping(value = "/users/addresses", method = RequestMethod.GET)
	public String getAllUserAddreses() {
		return "";
	}

	// to get individual address for a user
	@RequestMapping(value = "/users/{}/addresses/{}", method = RequestMethod.GET)
	public String getIndividualUserAddreses() {
		return "";
	}

}
