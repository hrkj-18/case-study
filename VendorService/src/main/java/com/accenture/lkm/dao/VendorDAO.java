package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import com.accenture.lkm.entity.VendorEntity;

@RepositoryDefinition(domainClass = VendorEntity.class, idClass = String.class)
public interface VendorDAO extends JpaRepository<VendorEntity, String> {
	List<VendorEntity> findAll();
}
