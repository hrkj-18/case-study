package com.accenture.lkm.test.dao;

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

import com.accenture.lkm.dao.MaterialCategoryDAO;
import com.accenture.lkm.dao.MaterialTypeDAO;
import com.accenture.lkm.entity.MaterialCategoryEntity;
import com.accenture.lkm.entity.MaterialTypeEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialTypeDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(MaterialTypeDAOTest.class);
	
	//Autowire the MaterialCategoryDAO object below
	@Autowired
	private MaterialTypeDAO materialTypeDAO;
	
	/*
	 * Method - notNullMaterialTypeDAOTest()
	 * Assert only that MaterialTypeDAO object is Not null
	 */	
	
	@Test
	public void notNullMaterialTypeDAOTest() {
		// Your Code Here
		assertNotNull("Material Type Object is not Null", materialTypeDAO);
		
	}
	
	
	/*
	 * Method - findByIdMaterialTypeTest()
	 * Using MaterialTypeDAO fetch an entity by its ID --> "C001" 
	 * Assert that the entity fetch and it is Not null 
	 * Assert that the name of the material Type entity fetch is equal to --> "Thread"
	 */
	
	@Test
	public void findByIdMaterialTypeTest() {
		// Your Code Here
		MaterialTypeEntity materialTypeEntity = materialTypeDAO.findOne("T001");
		
		assertNotNull("Entity object is not Null", materialTypeEntity);
		assertEquals(materialTypeEntity.getTypeName(),"Silk-Thread");
	}

	/*
	 * Method - findAllMaterialTypeTest()
	 * Using MaterialTypeDAO to fetch all the entities 
	 * Assert that the list is Not null 
	 * Assert that the count of entities matches to --> 3
	 */
			
	@Test
	public void findAllMaterialTypeTest() {
		// Your Code Here
		List<MaterialTypeEntity> entities = materialTypeDAO.findAll();
		assertNotNull("Entites are not null", entities);
		assertEquals(entities.size(), 6);
		
	}
	
}
