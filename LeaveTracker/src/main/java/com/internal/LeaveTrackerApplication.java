package com.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@ComponentScan("com.internal.*")
@Log4j2
public class LeaveTrackerApplication {

	public static void main(String[] args) {
		log.info("Leave Tracker application is Starting ....");
		log.error(SpringApplication.run(LeaveTrackerApplication.class, args));
		log.info("Leave Tracker application has Started!!!");
	}
}
