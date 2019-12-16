package com.accenture.lkm.dao;

import java.util.logging.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.entity.PurchaseEntity;

@Repository
public class PurchaseDAOWrapper {
	Logger logger = Logger.getLogger(PurchaseDAOWrapper.class.getName());
	@Autowired
	PurchaseDAO purchaseDAO;
	
	public PurchaseDAOWrapper() {
		// TODO Auto-generated constructor stub
	}
	
	public PurchaseBean addPurchaseEntity(PurchaseBean purchaseBean)
	{
		logger.info("Start Dao");
		PurchaseEntity purchaseEntity=new PurchaseEntity();
		PurchaseBean pBean=new PurchaseBean();
		
		BeanUtils.copyProperties(purchaseBean, purchaseEntity);
		logger.info(" "+purchaseEntity);
		PurchaseEntity persistEntity=purchaseDAO.save(purchaseEntity);
		logger.info(" "+persistEntity);
		persistEntity.setTransactionId(purchaseBean.getTransactionId()+persistEntity.getPurchaseId());
		
		 logger.info(" "+persistEntity);
		 persistEntity=purchaseDAO.save(persistEntity);
		 
		if(persistEntity!=null)
		{
			BeanUtils.copyProperties(persistEntity, pBean);
		}
		else
		{
			pBean=null;
		}
		logger.info("Purchase"+pBean.getTransactionId());
		logger.info("End Dao");
			return(pBean);
	}
	
	
}
