package com.accenture.lkm.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.dao.MaterialCategoryDAO;
import com.accenture.lkm.entity.MaterialCategoryEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialCategoryDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(MaterialCategoryDAOTest.class);
	
	//Autowire the MaterialCategoryDAO object below
	@Autowired
	private MaterialCategoryDAO materialCategoryDAO;
	
	/*
	 * Method - notNullMaterialCategoryDAOTest()
	 * Assert only that MaterialCategoryDAO object is Not null
	 */	
	
	@Test
	public void notNullMaterialCategoryDAOTest() {
		// Your Code Here
		assertNotNull("Material Category Object is not Null", materialCategoryDAO);
		
	}
	
	
	/*
	 * Method - findByIdMaterialCategoryTest()
	 * Using MaterialCategoryDAO fetch an entity by its ID --> "C001" 
	 * Assert that the entity fetch and it is Not null 
	 * Assert that the name of the material category entity fetch is equal to --> "Thread"
	 */
	
	@Test
	public void findByIdMaterialCategoryTest() {
		// Your Code Here
		MaterialCategoryEntity materialCategoryEntity = materialCategoryDAO.findOne("C001");
		
		assertNotNull("Entity object is not Null", materialCategoryEntity);
		assertEquals(materialCategoryEntity.getCategoryName(),"Thread");
	}

	/*
	 * Method - findAllMaterialCategoryTest()
	 * Using MaterialCategoryDAO to fetch all the entities 
	 * Assert that the list is Not null 
	 * Assert that the count of entities matches to --> 3
	 */
			
	@Test
	public void findAllMaterialCategoryTest() {
		// Your Code Here
		List<MaterialCategoryEntity> entities = materialCategoryDAO.findAll();
		assertNotNull("Entites are not null", entities);
		assertEquals(entities.size(), 3);
		
	}
	
}
