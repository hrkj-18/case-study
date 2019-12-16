package com.accenture.lkm.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import com.accenture.lkm.entity.PurchaseEntity;

@RepositoryDefinition(idClass=String.class,domainClass=PurchaseEntity.class)
public interface ReportDAO {

	@Query("select p from PurchaseEntity p where p.vendorName = ?1")
	List<PurchaseEntity> findAllPurchaseDetailsWithoutDate(String vendorName);
	
	@Query("select p from PurchaseEntity p where p.vendorName = ?1 and p.purchaseDate between ?2 and ?3")
	List<PurchaseEntity> findAllPurchaseDetailsWithDate(String vendorName, Date fromDate, Date toDate);
	
}
