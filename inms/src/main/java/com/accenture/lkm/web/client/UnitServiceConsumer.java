package com.accenture.lkm.web.client;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.exceptions.MicroServiceException;

@Service
@SuppressWarnings(value = { "all" })
public class UnitServiceConsumer {
		
	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;
	
	@Value("${UnitServiceConsumer.apiURL}")
	private String apiURL;
	
	@Value("${UnitServiceConsumer.apiURLByCategoryId}")
	private String apiURLByCategoryId;
	
	private List<UnitBean> unitBeanList;
	
	private Map<String, String> unitMap;
	
	private RestTemplate restTemplate;	
	
	
	public UnitServiceConsumer(){
		restTemplate =  new RestTemplate();
	}
	
	public Map<String, String> getUnitMap() throws MicroServiceException {
		// Write Your Code Here
		if(unitMap == null) {
			unitMap = getUnitBeanList().stream()
							.collect(Collectors.toMap(unitBean -> unitBean.getUnitId(), unitBean -> unitBean.getUnitName()));
		}
		return unitMap;
	}
	
	public List<UnitBean> getUnitBeanList() throws MicroServiceException {
		// Write Your Code Here
		if(unitBeanList == null) {
			hitGetUnitDetails();
		}
		return unitBeanList;
	}
	
	/**
	 * This method is hitting microservice to get the list of unit.
	 * 
	 * @return
	 * @throws MicroServiceException 
	 */
	private void hitGetUnitDetails() throws MicroServiceException {
		// Write Your Code Here
		try {
			ResponseEntity<UnitBean[]> response = restTemplate.getForEntity(serviceURL + apiURL, UnitBean[].class);
			List<UnitBean> unitList = Arrays.asList(response.getBody());
			this.unitBeanList = unitList;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new MicroServiceException();
		}
	}

	/**
	 * This method is hitting microservice to get the list of unit available for a given category id.
	 * @param categoryId
	 * @return
	 * @throws MicroServiceException 
	 */
	public List<UnitBean> hitGetUnitsByCategoryId(String categoryId) throws MicroServiceException{
		// Write Your Code Here
		List<UnitBean> unitBeanList;
		try {
			ResponseEntity<UnitBean[]> response = restTemplate.getForEntity(serviceURL + apiURLByCategoryId + categoryId, UnitBean[].class);
			unitBeanList = Arrays.asList(response.getBody());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new MicroServiceException();
		}
		
		return unitBeanList;
	}

}
