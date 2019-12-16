package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import com.accenture.lkm.entity.UnitEntity;

@RepositoryDefinition(idClass = String.class, domainClass = UnitEntity.class)
public interface UnitDAO {

	public List<UnitEntity> findAll();

	public UnitEntity findOne(String unitId);

	@Query("select p from UnitEntity p where p.categoryEntity.categoryId= ?1")
	public List<UnitEntity> findByCategoryId(String categoryId);
}
