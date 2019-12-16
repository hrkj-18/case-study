package com.accenture.lkm.service;

import java.util.Date;
import java.util.List;

//import java.sql.Date;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.entity.PurchaseEntity;

public interface ReportService {

	public List<PurchaseBean> findAllPurchaseDetailsWithoutDate(String vendorName);
	public List<PurchaseBean> findAllPurchaseDetailsWithDate(String vendorName, Date fromDate, Date toDate);

}
