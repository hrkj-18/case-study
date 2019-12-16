package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.dao.VendorDAO;
import com.accenture.lkm.entity.VendorEntity;

@Service
public class VendorServiceImpl implements VendorService {


	Logger logger = Logger.getLogger(VendorServiceImpl.class.getName());
	/*
	 * Autowire VendorDAO object
	 * 
	 */
	@Autowired
	public VendorDAO vendorDAO;

	// Your Code Here

	/*
	 * Method - getVendorDetails() Use the VendorDAO to get all the vendors Check if
	 * vendors is not empty then Declare VendorBean object with null value Loop
	 * through all the vendors Create a new bean object Copy each property value of
	 * entity object to bean object Add the bean object to the vendorBeans list
	 */

	@Override
	public List<VendorBean> getVendorDetails() {
		List<VendorBean> vendorBeans = new ArrayList<>();

		List<VendorEntity> vendorEntity = vendorDAO.findAll();
		for (VendorEntity ve : vendorEntity) {
			VendorBean vb = new VendorBean();
			BeanUtils.copyProperties(ve, vb);
			vendorBeans.add(vb);
		}
		return vendorBeans;
	}

}
