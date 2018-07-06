package com.internal.serviceImpl;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.internal.dao.RegisterDao;
import com.internal.dao.SaveDetailsDao;
import com.internal.dto.RegisterBean;
import com.internal.entity.AppUserDetails;
import com.internal.entity.EQEmployee;
import com.internal.entity.EQEmployeeRole;
import com.internal.entity.EQTeam;
import com.internal.entity.EQVMDetails;
import com.microsoft.sqlserver.jdbc.StringUtils;

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

	public RegisterBean findObject(Long empId) {
		registerDao.removeLockOnVM(empId);
		EQEmployee editEmployee = registerDao.findObject(empId);
		RegisterBean registerBean = modelMapper.map(editEmployee, RegisterBean.class);
		String rolesDescription = registerDao.getRoleDescriptionbyId(editEmployee.getReferenceRole().getRoleId());
		String vmDescription = StringUtils.EMPTY;
		if (null != editEmployee.getVm()) {
			vmDescription = registerDao.getVmDescriptionById(editEmployee.getVm().getVmId());
		}
		String teamDescription = registerDao.getTeamDescriptionById(editEmployee.getRefernceTeam().getTeamId());
		registerBean.setReferenceRole(rolesDescription);
		registerBean.setRefernceTeam(teamDescription);
		registerBean.setVm(vmDescription);
		AppUserDetails appDetails = editEmployee.getAppDetails();
		if (appDetails.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
			registerBean.setIsAdmin("true");
		} else {
			registerBean.setIsAdmin("false");
		}
		registerBean.setEmployeeActive(editEmployee.getEmployeeActive());
		registerBean.setEmployeeProductive(editEmployee.getEmployeeProductive());
		// registerBean.setPassword(appDetails.getPassword());
		registerDao.removeReference(empId);
		return registerBean;
	}

	public String save(RegisterBean registerBean, String level) {
		EQEmployee employee = modelMapper.map(registerBean, EQEmployee.class);
		Optional<EQEmployeeRole> roles = registerDao.getRoles(registerBean.getReferenceRole()).stream().findFirst();
		Optional<EQVMDetails> vm = registerDao.getVM(registerBean.getVm()).stream().findFirst();
		Optional<EQTeam> referenceTeam = registerDao.getTeam(registerBean.getRefernceTeam()).stream().findFirst();
		EQVMDetails vmDetails = vm.get();
		vmDetails.setIsAssigned("Y");
		employee.setReferenceRole(roles.get());
		employee.setRefernceTeam(referenceTeam.get());
		employee.setVm(vmDetails);
		Optional<String> isActive = Optional.ofNullable(registerBean.getEmployeeActive());
		if (isActive.isPresent()) {
			employee.setEmployeeActive("true");
		} else {
			employee.setEmployeeActive("false");
		}
		Optional<String> isProductive = Optional.ofNullable(registerBean.getEmployeeProductive());
		if (isProductive.isPresent()) {
			employee.setEmployeeProductive("true");
		} else {
			employee.setEmployeeProductive("false");
		}
		if (null != registerBean.getPassword()) {
			AppUserDetails appDetails = new AppUserDetails();
			appDetails.setUserName(registerBean.getEmployeeId().toString());
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String Password = passwordEncoder.encode(registerBean.getPassword());
			appDetails.setPassword(Password);
			Optional<String> isAdmin = Optional.ofNullable(registerBean.getIsAdmin());
			if (isAdmin.isPresent()) {
				appDetails.setRole("ROLE_ADMIN");
			} else {
				appDetails.setRole("ROLE_USER");
			}
			int active = employee.getEmployeeActive().equalsIgnoreCase("true") ? 1 : 0;
			appDetails.setEnabled(active);
			employee.setAppDetails(appDetails);
		}
		if (level.equalsIgnoreCase("edit")) {
			EQEmployee editEmployee = registerDao.findObject(registerBean.getEmployeeId());
			AppUserDetails appDetails = editEmployee.getAppDetails();
			employee.setAppDetails(appDetails);
		}
		employee.setUpdatedDate(Calendar.getInstance().getTime());
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
