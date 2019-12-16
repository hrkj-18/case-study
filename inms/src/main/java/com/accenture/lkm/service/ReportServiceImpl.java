package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.dao.ReportDAO;
import com.accenture.lkm.entity.PurchaseEntity;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.accenture.lkm.web.client.MaterialCategoryConsumer;
import com.accenture.lkm.web.client.MaterialTypeConsumer;

@Service
public class ReportServiceImpl implements ReportService{
	
	Logger logger = Logger.getLogger(ReportServiceImpl.class.getName());
	
	MaterialCategoryConsumer mcc;
	
	@Autowired
	private ReportDAO reportDAO;
	
	@Override
	public List<PurchaseBean> findAllPurchaseDetailsWithoutDate(String vendorName) {
		// TODO Auto-generated method stub
		logger.info("Name :"+vendorName);
		
		List<PurchaseEntity> purchaseEntities=new ArrayList<PurchaseEntity>();
		List<PurchaseBean> purchaseBeans=new ArrayList<PurchaseBean>();
		purchaseEntities = reportDAO.findAllPurchaseDetailsWithoutDate(vendorName);
		logger.info(""+purchaseEntities);
		logger.info(""+purchaseEntities.size());
		logger.info("In service");
		for(PurchaseEntity purchaseEntity:purchaseEntities) {
			logger.info("before bean obj");
			PurchaseBean purchaseBean = new PurchaseBean();
			logger.info("before copy");
			BeanUtils.copyProperties(purchaseEntity, purchaseBean);
			logger.info("before add");
			
//			String mtn; 
//			try {
//				logger.info("Before mtn");
//				logger.info(purchaseEntity.getMaterialCategoryId());
//				mtn = mcc.getCategoryMap().get(purchaseBean.getMaterialCategoryId()); 
//				logger.info("After mtn : "+mtn);
//				purchaseBean.setMaterialCategoryName(mtn);
//			  } catch (MicroServiceException e) { 
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			  }
			  purchaseBeans.add(purchaseBean);
			  logger.info("bean in service :"+purchaseBean);
		}
		logger.info("In service before beans");
		for(PurchaseBean p :purchaseBeans ) {
		logger.info("In Service" + p);}
		return purchaseBeans;
	}

	@Override
	public List<PurchaseBean> findAllPurchaseDetailsWithDate(String vendorName, Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		
		List<PurchaseEntity> purchaseEntities=new ArrayList<PurchaseEntity>();
		List<PurchaseBean> purchaseBeans=new ArrayList<PurchaseBean>();
		purchaseEntities = reportDAO.findAllPurchaseDetailsWithDate(vendorName, fromDate, toDate);
		
		
		for(PurchaseEntity purchaseEntity:purchaseEntities) {
			PurchaseBean purchaseBean = new PurchaseBean();
			BeanUtils.copyProperties(purchaseEntity, purchaseBean);
			purchaseBeans.add(purchaseBean);
		}
		for(PurchaseBean p :purchaseBeans ) {
			logger.info(""+p);}
		return purchaseBeans;
	}

}
