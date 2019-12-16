package com.accenture.lkm.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.service.VendorService;

@RestController
public class VendorController {
	
	Logger logger = Logger.getLogger(VendorController.class.getName());
	
	/*
	 * Autowire the VendorService object
	 * 
	 */
	// Your Code Here
	@Autowired
	public VendorService vendorService;

	@GetMapping("/")
	public String index() {
		return "Welcome to Spring Boot Vendor Service API!";
	}

	/*
	 * Method - getVendorDetails() Fetch all the vendor details using VendorService
	 * and store it inside a List Return a ResponseEntity object passing the list of
	 * vendor details
	 * 
	 */
	@RequestMapping(value = "/vendor/controller/getVendors",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VendorBean>> getVendorDetails() 
	{	
		logger.info("Inside Vendors Controller -> getVendorDetails()");
		List<VendorBean> listVB = vendorService.getVendorDetails();	
		return new ResponseEntity<List<VendorBean>>(listVB,HttpStatus.OK);		
	}
}
