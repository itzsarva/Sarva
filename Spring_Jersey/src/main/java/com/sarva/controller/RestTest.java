package com.sarva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarva.service.AddObjects;

@RestController
public class RestTest {

	@Autowired
	private AddObjects add;

	@RequestMapping("/get")
	public String name() {
		return "hello";
	}

	@RequestMapping("/add")
	public String add() {
		add.addObjects();
		return "success";
	}

}
