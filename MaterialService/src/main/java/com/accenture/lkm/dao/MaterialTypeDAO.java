package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import com.accenture.lkm.entity.MaterialTypeEntity;

@RepositoryDefinition(idClass = String.class, domainClass = MaterialTypeEntity.class)
public interface MaterialTypeDAO {

	public MaterialTypeEntity findOne(String id);

	public List<MaterialTypeEntity> findAll();

	@Query("select p from MaterialTypeEntity p where p.categoryEntity.categoryId= ?1")
	public List<MaterialTypeEntity> findByCategoryId(String categoryId);

}
