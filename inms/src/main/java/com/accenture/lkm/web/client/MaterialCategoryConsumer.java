package com.accenture.lkm.web.client;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.accenture.lkm.service.ReportServiceImpl;

@Service
@SuppressWarnings(value = { "all" })
public class MaterialCategoryConsumer {
	
	Logger logger = Logger.getLogger(MaterialCategoryConsumer.class.getName());
	
	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;
	@Value("${MaterialCategoryConsumer.apiURL}")
	private String apiURL;
	@Value("${MaterialCategoryConsumer.apiURLByCategoryId}")
	private String apiURLByCategoryId;
	
	private RestTemplate restTemplate;
	private List<MaterialCategoryBean> materialCategoryBeanList;
	private Map<String, String> categoryMap;

	
	public MaterialCategoryConsumer() {
		restTemplate = new RestTemplate();
	}
	
	public Map<String, String> getCategoryMap() throws MicroServiceException {
		// Write Your Code Here
		if(categoryMap == null) {
			categoryMap = getMaterialCategoryBeanList().stream()
							.collect(Collectors.toMap(materialCategoryBean -> materialCategoryBean.getCategoryId(), materialCategoryBean -> materialCategoryBean.getCategoryName()));
		}
		return categoryMap;
	}

	public List<MaterialCategoryBean> getMaterialCategoryBeanList() throws MicroServiceException {

		// Write Your Code Here
//		if(materialCategoryBeanList == null) {
			hitGetMaterialCategories();
//		}

		return materialCategoryBeanList;
	}

	/**
	 * This method is hitting microservice to get the list of Material category.
	 * 
	 * @return
	 * @throws MicroServiceException
	 */
	private void hitGetMaterialCategories() throws MicroServiceException {
		// Write Your Code Here
		try {
			logger.info("Entered Material Category Consumer"+serviceURL + apiURL);
			ResponseEntity<MaterialCategoryBean[]> response = restTemplate.getForEntity(serviceURL + apiURL, MaterialCategoryBean[].class);
			List<MaterialCategoryBean> materialCategoryBeanList1 = Arrays.asList(response.getBody());
			this.materialCategoryBeanList = materialCategoryBeanList1;
			logger.info(""+materialCategoryBeanList);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new MicroServiceException();
		}
	}

	/**
	 * This method is hitting microservice to get the details of Material category
	 * for given category id.
	 * 
	 * @param categoryId
	 * @return
	 * @throws MicroServiceException
	 */
	public MaterialCategoryBean hitGetMaterialCategoryById(String categoryId) throws MicroServiceException {
		MaterialCategoryBean materialCategoryBean = null;
		// Write Your Code Here
		// For REST URI use --> serviceURL + apiURL + apiURLByCategoryId
		
		try {
			logger.info("Entered Material Category Consumer By ID");
			ResponseEntity<MaterialCategoryBean> response = restTemplate.getForEntity(serviceURL + apiURLByCategoryId + categoryId, MaterialCategoryBean.class);
			materialCategoryBean = response.getBody();
			logger.info(""+materialCategoryBean);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new MicroServiceException();
		}	
		return materialCategoryBean;
	}
}
