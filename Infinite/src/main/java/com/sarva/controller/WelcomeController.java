package com.sarva.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sarva.entity.EmployeeDetail;
import com.sarva.process.InputProcessor;
import com.sarva.service.GatherinfoService;

@Controller
public class WelcomeController {

	@Autowired
	private InputProcessor process;

	@Autowired
	private GatherinfoService service;

	// inject via application.properties
	// @Value("${welcome.message:test}")
	private String message = "Hello User";

	// setting up the initial value
	@RequestMapping("/")
	public ModelAndView welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return new ModelAndView("index", model);
	}

	@GetMapping("/query")
	@ResponseBody
	public Object query(@RequestParam(value = "key") String key) {
		String value = "Please Provide a correct question from the catalog";
		List<EmployeeDetail> empDetail = null;
		// for leavers and joiners over a period of time
		if (key.contains("Tell me new joiners of") || key.contains("Tell me new leavers of")) {
			int tellMeLength = 23;
			String name = key.substring(tellMeLength, key.length());
			String[] valuesObtained = name.split(" ");
			if (valuesObtained.length == 2) {
				String thirdParam = valuesObtained[0];
				String pointer;
				if (key.contains("Leavers")) {
					pointer = "Leavers";
					valuesObtained[1] = valuesObtained[1] + pointer;
				}
				if (thirdParam.equalsIgnoreCase("this")) {
					return process.doProcessTimePeriod(empDetail, valuesObtained);
				}
			}
			if (valuesObtained.length == 3) {
				String pointer;
				if (key.contains("Leavers")) {
					pointer = "Leavers";
					valuesObtained[2] = valuesObtained[2] + pointer;
				}
				return process.getMonths(empDetail, valuesObtained);
			}
		} else if (key.contains("Tell me joiners between") || key.contains("Tell me leavers between")) {
			int tellMeLength = 24;
			String name = key.substring(tellMeLength, key.length());
			String[] valuesObtained = name.split(" ");
			if (valuesObtained.length == 5) {
				String pointer;
				if (key.contains("Leavers")) {
					pointer = "Leavers";
					valuesObtained[4] = valuesObtained[4] + pointer;
				}
				return process.getBetween(empDetail, valuesObtained);
			}
		}
		// count of all employee
		else if (key.contains("Tell me count of all the")) {
			int tellMeLength = 25;
			String name = key.substring(tellMeLength, key.length());
			String[] valuesObtained = name.split(" ");
			return process.getCount(valuesObtained);
		}
		// get individual records of individuals
		else if (key.contains("Tell me")) {
			int tellMeLength = "Tell me ".length();
			String name = key.substring(tellMeLength, key.length());
			String[] valuesObtained = name.split(" ");
			empDetail = process.doProcess(valuesObtained);
			if (empDetail.size() == 1) {
				return process.doSingleProcess(empDetail, valuesObtained);
			}
			return value;
		}
		return value;
	}

	// method to store values in the table;
	// add logic or send a json object to add the value here
	// get the json in the Request Object
	@GetMapping("/addObject")
	public String addObject() {
		service.addobject();
		return "successfullyAdded";
	}

}