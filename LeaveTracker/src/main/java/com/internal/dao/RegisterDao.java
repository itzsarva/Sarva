package com.internal.dao;

import java.util.List;

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

	public EQEmployee findObject(Long arg0);

	public String save(EQEmployee arg0);

	public List<EQTeam> getTeam(String description);

	public List<EQVMDetails> getVM(String description);

	public List<EQEmployeeRole> getRoles(String description);

	public String getTeamDescriptionById(Long id);

	public String getVmDescriptionById(Long id);

	public String getRoleDescriptionbyId(Long id);

	public void removeLockOnVM(Long id);

	public void removeReference(Long id);
}
