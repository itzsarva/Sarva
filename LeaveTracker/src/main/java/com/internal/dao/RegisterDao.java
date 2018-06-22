package com.internal.dao;

import java.util.List;
import java.util.Optional;

import com.internal.entity.EQEmployee;
import com.internal.entity.EQEmployeeRole;
import com.internal.entity.EQTeam;
import com.internal.entity.EQVMDetails;

/**
 * @author ravis3
 *
 */
public interface RegisterDao {

	public void deleteById(Long arg0);

	public boolean findById(Long arg0);

	public Optional<EQEmployee> findObject(Long arg0);

	public String save(EQEmployee arg0);

	public List<EQTeam> getTeam(String description);

	public List<EQVMDetails> getVM(String description);

	public List<EQEmployeeRole> getRoles(String description);
}
