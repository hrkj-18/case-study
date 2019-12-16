package com.accenture.lkm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.logging.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.dao.PurchaseDAOWrapper;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.accenture.lkm.web.client.MaterialCategoryConsumer;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	
	Logger logger = Logger.getLogger(PurchaseServiceImpl.class.getName());
	@Autowired
	PurchaseDAOWrapper daoWrapper;

	MaterialCategoryConsumer mcc;

	@Override
	public PurchaseBean addPurchaseEntry(PurchaseBean purchaseBean) {
		// TODO Auto-generated method stub
		PurchaseBean purchaseBean1;
		logger.info("Start service");
		String id = purchaseIdGenerator(purchaseBean);
		purchaseBean.setTransactionId(id);
		purchaseBean1 = daoWrapper.addPurchaseEntity(purchaseBean);
		logger.info("End service");
		return (purchaseBean1);
	}

	private String purchaseIdGenerator(PurchaseBean purchaseBean) {

		logger.info(""+purchaseBean.getPurchaseDate());
		StringBuilder key = new StringBuilder("P_");
		key.append(purchaseBean.getVendorName().toUpperCase(), 0, 3);
		key.append("_");

		String temp = (purchaseBean.getPurchaseDate() + "").substring(4, 8);
		Date date = new Date();
		try {
			date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(temp);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		logger.info("Month is: " + (month + 1));

		String pDate = (purchaseBean.getPurchaseDate() + "").substring(8, 10) + (month + 1)
				+ (purchaseBean.getPurchaseDate() + "").substring(24, 28);
		logger.info(pDate);

		key.append(pDate);
		key.append("_");

		key.append(purchaseBean.getMaterialCategoryName().toUpperCase().substring(0, 3));

		key.append("_");
//		key.append(" aaa");
		return key.toString();

	}

}
