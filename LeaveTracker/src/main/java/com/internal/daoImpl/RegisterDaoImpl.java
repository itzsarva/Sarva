package com.internal.daoImpl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.internal.dao.RegisterDao;
import com.internal.entity.EQEmployee;

@Repository
public class RegisterDaoImpl implements RegisterDao {

	@Override
	public void deleteById(Long arg0) {
	}

	@Override
	public String save(EQEmployee arg0) {
		return null;
	}

	@Override
	public boolean findById(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<EQEmployee> findObject(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
