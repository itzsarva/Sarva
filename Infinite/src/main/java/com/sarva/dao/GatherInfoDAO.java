package com.sarva.dao;

import java.util.List;

import com.sarva.entity.EmployeeDetail;

public interface GatherInfoDAO {

	public List<EmployeeDetail> getSingleNameAndOther(String... strings);

	public void addObject();

	public List<EmployeeDetail> getTimePeriod(String[] valuesObtained);

	public List<EmployeeDetail> getMonths(String[] valuesObtained);

	public List<EmployeeDetail> getBetween(String[] valuesObtained);

	public Long getCount(String[] valuesObtained);

}
