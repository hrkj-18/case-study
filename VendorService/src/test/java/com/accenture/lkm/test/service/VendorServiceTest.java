package com.accenture.lkm.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Collection;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.service.VendorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(VendorServiceTest.class);

	//Autowire the VendorService object below
	@Autowired
	private VendorService vendorService;

	//Method - notNullVendorServiceTest()
	//Assert only that VendorService object is Not null

	@Test
	public void notNullVendorServiceTest() {
		assertNotNull("VendorService object is not Null", vendorService);
	}

	/*
	 * Method - notNullGetVendorDetailsTest()
	 * Assert only that VendorService getVendorDetails is not returning a null value
	 * 
	 */

	@Test
	public void notNullGetVendorDetailsTest() {
		// Your Code Here
		List<VendorBean> vendeorServiceDetails = vendorService.getVendorDetails();
		assertNotNull("VendorService Details object is not Null", vendeorServiceDetails);
	}

	/*
	 * Method - countGetVendorDetailsTest()
	 * Assert only that VendorService getVendorDetails list size matches to 5
	 * 
	 */

	@Test
	public void countGetVendorDetailsTest() {
		// Your Code Here
		assertEquals(vendorService.getVendorDetails().size(),5);
	}

	/*
	 * Method - recordGetVendorDetailsTest()
	 * Assert only that VendorService getVendorDetails first bean name matches --> "Only Vimal"
	 * 
	 */
		
	@Test
	public void recordGetVendorDetailsTest() {
		assertEquals(vendorService.getVendorDetails().get(0).getVendorName(), "Only Vimal");
	}

}