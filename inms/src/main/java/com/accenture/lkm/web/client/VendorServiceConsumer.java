package com.accenture.lkm.web.client;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.accenture.lkm.web.controller.VendorPurchaseReportController;

@Service
public class VendorServiceConsumer {
	
	Logger logger = Logger.getLogger(VendorServiceConsumer.class.getName());

	@Value("${VendorServiceConsumer.serviceURL}")
	private String serviceURL;

	@Value("${VendorServiceConsumer.apiURL}")
	private String apiURL;

	private RestTemplate restTemplate;

	List<VendorBean> vendorBeanList;

	Map<String, VendorBean> vendorBeanMap;

	public VendorServiceConsumer() {
		restTemplate = new RestTemplate();
	}
	
	public Map<String, VendorBean> getVendorBeanMap() throws MicroServiceException {
		if(vendorBeanMap == null) {
			vendorBeanMap = getVendorBeanList().stream()
							.collect(Collectors.toMap(vendorBean -> vendorBean.getVendorId(), vendorBean -> vendorBean));
		}
		return vendorBeanMap;		
	}

	public List<VendorBean> getVendorBeanList() throws MicroServiceException {
		if(vendorBeanList == null) {
			hitVendorService();
		}
		return vendorBeanList;
	}

	public void hitVendorService() throws MicroServiceException {
		try {
			logger.info("Entered Vendor Consumer");
			ResponseEntity<VendorBean[]> response = restTemplate.getForEntity(serviceURL + apiURL, VendorBean[].class);
			List<VendorBean> vendorList = Arrays.asList(response.getBody());
			this.vendorBeanList = vendorList;
			logger.info(""+vendorBeanList);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new MicroServiceException();
		}
	}
}
