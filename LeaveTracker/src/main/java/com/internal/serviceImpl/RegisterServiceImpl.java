package com.internal.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.dao.RegisterDao;
import com.internal.dao.SaveDetailsDao;
import com.internal.dto.RegisterBean;
import com.internal.entity.EQEmployee;
import com.internal.entity.EQEmployeeRole;
import com.internal.entity.EQTeam;
import com.internal.entity.EQVMDetails;

@Service
@Transactional
public class RegisterServiceImpl {

	@Autowired
	RegisterDao registerDao;

	@Autowired
	SaveDetailsDao saveDetailsDao;

	@Autowired
	ModelMapper modelMapper;

	public void deleteById(Long arg0) {
	}

	public RegisterBean findObject(Long arg0) {
		return null;
	}

	public String save(RegisterBean registerBean) {
		EQEmployee employee = modelMapper.map(registerBean, EQEmployee.class);
		Optional<EQEmployeeRole> roles = registerDao.getRoles(registerBean.getReferenceRole()).stream().findFirst();
		Optional<EQVMDetails> vm = registerDao.getVM(registerBean.getVm()).stream().findFirst();
		Optional<EQTeam> referenceTeam = registerDao.getTeam(registerBean.getRefernceTeam()).stream().findFirst();
		employee.setReferenceRole(roles.get());
		employee.setRefernceTeam(referenceTeam.get());
		employee.setVm(vm.get());
		return registerDao.save(employee);
	}

	public boolean findById(Long arg0) {
		return registerDao.findById(arg0);
	}

	public List<String> getRoles() {
		List<EQEmployeeRole> roles = registerDao.getRoles(null);
		return roles.stream().map(a -> a.getDescription()).collect(Collectors.toList());
	}

	public List<String> getVM() {
		List<EQVMDetails> vmDetails = registerDao.getVM(null);
		return vmDetails.stream().map(a -> a.getIp()).collect(Collectors.toList());
	}

	public List<String> getTeam() {
		List<EQTeam> teams = registerDao.getTeam(null);
		return teams.stream().map(a -> a.getDescription()).collect(Collectors.toList());
	}

	public String saveAll() {
		return saveDetailsDao.saveTeam();
	}

}
