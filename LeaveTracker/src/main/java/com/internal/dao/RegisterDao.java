package com.internal.dao;

import java.util.Optional;

import com.internal.entity.EQEmployee;

public interface RegisterDao {

	public void deleteById(Long arg0);

	public boolean findById(Long arg0);

	public Optional<EQEmployee> findObject(Long arg0);

	public String save(EQEmployee arg0);
}
