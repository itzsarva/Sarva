package com.internal.reportgen;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private Integer empId;
	private String empName;
	private boolean productiveResource;
	private LinkedHashMap<String, String> attendenceInformation;
	
	public Employee() {
		
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public boolean isProductiveResource() {
		return productiveResource;
	}
	public void setProductiveResource(boolean productiveResource) {
		this.productiveResource = productiveResource;
	}
	public LinkedHashMap<String, String> getAttendenceInformation() {
		return new LinkedHashMap<>(attendenceInformation);
	}
	public void setAttendenceInformation(LinkedHashMap<String, String> attendenceInformation) {
		this.attendenceInformation = new LinkedHashMap<>(attendenceInformation);
	}
	
}
