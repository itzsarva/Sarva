package com.sarva.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sarva.dto.RestTest;

@RestController
public class MvcRestController {
	@RequestMapping(value = "/restGet/{name}", method = RequestMethod.GET)
	public Map<String, String> returnSome(@PathVariable("name") String name) {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("age", "you know what it is");
		return map;
	}

	@RequestMapping("/restTest")
	public List<RestTest> returnRestTest() {
		RestTest test1 = new RestTest();
		test1.setAttOne("Testone");
		test1.setAttTwo("TestTwo");
		test1.setAttThree("testThree");
		RestTest test2 = new RestTest();
		test2.setAttOne("TestTwoone");
		test2.setAttTwo("TestTwoTwo");
		test2.setAttThree("testTwoThree");
		List<RestTest> testList = new ArrayList<RestTest>();
		testList.add(test1);
		testList.add(test2);
		return testList;

	}
}
