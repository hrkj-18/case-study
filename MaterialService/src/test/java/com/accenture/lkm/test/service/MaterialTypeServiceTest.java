package com.accenture.lkm.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.service.MaterialTypeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialTypeServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(MaterialTypeServiceTest.class);
	
	//Autowire the MaterialTypeService object below
	@Autowired
	private MaterialTypeService materialTypeService;
	
	// Your Code Here

	//Method - notNullMaterialTypeServiceTest()
	//Assert only that MaterialTypeService object is Not null
	
	@Test
	public void notNullMaterialTypeServiceTest() {
		// Your Code Here
		assertNotNull("Material Type Object Not null", materialTypeService);
	}
	
		
	/*
	 * Method - getMaterialCategoryByIdTest()
	 * Assert that MaterialCategoryBean object fetch using MaterialTypeService getMaterialCategoryById --> C001 is not null
	 * Assert that object fetch name is equal to --> "Thread"
	 */
	
	@Test
	public void getMaterialCategoryByIdTest() {
		// Your Code Here
		assertNotNull("Material Service getMaterialCategoryById Bean Not null",materialTypeService.getMaterialTypes("C001").get(0));
		assertEquals(materialTypeService.getMaterialTypes("C001").get(0).getTypeName(), "Silk-Thread");
	}
	
	
	/*
	 * Method - getMaterialCategoriesTest()
	 * Assert that MaterialCategoryBean list fetch using MaterialTypeService getMaterialCategories is not null
	 * Assert that list size matches to --> 3
	 */
	
	@Test
	public void getMaterialCategoriesTest() {
		// Your Code Here
		List<MaterialTypeBean> beans = materialTypeService.getMaterialTypes();
		assertEquals(beans.size(), 6);

	}
	
}
