package com.sarva.service;

import java.util.List;

import com.sarva.entity.EmployeeDetail;

public interface GatherinfoService {

	public List<EmployeeDetail> getSingleNameAndOther(String... strings);

	public void addobject();

	public List<EmployeeDetail> getTimePeriod(String[] valuesObtained);

	public List<EmployeeDetail> getMonths(String[] valuesObtained);

	public List<EmployeeDetail> getBetween(String[] valuesObtained);

	public Long getCount(String[] valuesObtained);

}
