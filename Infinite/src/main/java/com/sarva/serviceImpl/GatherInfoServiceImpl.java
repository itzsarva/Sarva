package com.sarva.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarva.dao.GatherInfoDAO;
import com.sarva.entity.EmployeeDetail;
import com.sarva.service.GatherinfoService;

@Service
public class GatherInfoServiceImpl implements GatherinfoService {

	@Autowired
	private GatherInfoDAO dao;

	@Override
	public List<EmployeeDetail> getSingleNameAndOther(String... strings) {
		return dao.getSingleNameAndOther(strings);
	}

	@Override
	public void addobject() {
		dao.addObject();
	}

	@Override
	public List<EmployeeDetail> getTimePeriod(String[] valuesObtained) {
		return dao.getTimePeriod(valuesObtained);
	}

	public List<EmployeeDetail> getMonths(String[] valuesObtained) {
		return dao.getMonths(valuesObtained);
	}

	@Override
	public List<EmployeeDetail> getBetween(String[] valuesObtained) {
		return dao.getBetween(valuesObtained);
	}

	@Override
	public Long getCount(String[] valuesObtained) {
		return dao.getCount(valuesObtained);
	}

}
