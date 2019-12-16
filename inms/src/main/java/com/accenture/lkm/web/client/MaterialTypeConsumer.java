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
import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.exceptions.MicroServiceException;

@Service
@SuppressWarnings(value = { "all" })
public class MaterialTypeConsumer {
		
	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;
	
	@Value("${MaterialTypeConsumer.apiURL}")
	private String apiURL;
	
	@Value("${MaterialTypeConsumer.apiURLByCategoryId}")
	private String apiURLByCategoryId;
	
	private RestTemplate restTemplate;
	
	private List<MaterialTypeBean> materialTypeBeanList;
	
	private Map<String, String> categoryTypeMap;
	
	public MaterialTypeConsumer() {
		restTemplate = new RestTemplate();
	}

	public Map<String, String> getCategoryTypeMap() throws MicroServiceException {
		// Write Your Code Here
		if(categoryTypeMap == null) {
			categoryTypeMap = getMaterialTypeBeanList().stream()
							.collect(Collectors.toMap(materialCategoryTypeBean -> materialCategoryTypeBean.getTypeId(), materialCategoryTypeBean -> materialCategoryTypeBean.getTypeName()));
		}
		return categoryTypeMap;
	}
	
	public List<MaterialTypeBean> getMaterialTypeBeanList() throws MicroServiceException {
		// Write Your Code Here
		if(materialTypeBeanList == null) {
			hitGetMaterialType();
		}
		return materialTypeBeanList;
	}
	
	/**
	 * This method is hitting microservice to get the list of Material type.
	 * 
	 * @return
	 * @throws MicroServiceException 
	 */
	private void hitGetMaterialType() throws MicroServiceException {
		// Write Your Code Here
		try {
			ResponseEntity<MaterialTypeBean[]> response = restTemplate.getForEntity(serviceURL + apiURL, MaterialTypeBean[].class);
			List<MaterialTypeBean> materialTypeList = Arrays.asList(response.getBody());
			this.materialTypeBeanList = materialTypeList;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new MicroServiceException();
		}
	}

	/**
	 * This method is hitting microservice to get the details of Material type based on category id.
	 * @param categoryId
	 * @return
	 * @throws MicroServiceException 
	 */
	public List<MaterialTypeBean> hitGetTypesBasedOnCategoryId(String categoryId) throws MicroServiceException {
		// Write Your Code Here
		// For REST URI use -->  serviceURL + apiURL + apiURLByCategoryId
		List<MaterialTypeBean> materialTypeBeanList;
		try {
			ResponseEntity<MaterialTypeBean[]> response = restTemplate.getForEntity(serviceURL + apiURLByCategoryId + categoryId, MaterialTypeBean[].class);
			materialTypeBeanList = Arrays.asList(response.getBody());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new MicroServiceException();
		}
		
		return materialTypeBeanList;
	}

}
