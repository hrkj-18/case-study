package com.accenture.lkm.dao;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.LoginEntity;

@RepositoryDefinition(idClass=String.class,domainClass=LoginEntity.class)
@Transactional
public interface LoginDAO {

	LoginEntity findOne(String username);
	
}
