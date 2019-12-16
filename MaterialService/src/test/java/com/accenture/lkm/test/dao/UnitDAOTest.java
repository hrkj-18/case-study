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

import com.accenture.lkm.dao.UnitDAO;
import com.accenture.lkm.entity.UnitEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(UnitDAOTest.class);
	
	//Autowire the UnitDAO object below
	@Autowired
	private UnitDAO unitDAO;
	
	/*
	 * Method - notNullUnitDAOTest()
	 * Assert only that UnitDAO object is Not null
	 */	
	
	@Test
	public void notNullUnitDAOTest() {
		// Your Code Here
		assertNotNull("Unit Object is not Null", unitDAO);
		
	}
	
	
	/*
	 * Method - findByIdUnitTest()
	 * Using UnitDAO fetch an entity by its ID --> "C001" 
	 * Assert that the entity fetch and it is Not null 
	 * Assert that the name of the material category entity fetch is equal to --> "Thread"
	 */
	
	@Test
	public void findByIdUnitTest() {
		// Your Code Here
		UnitEntity UnitEntity = unitDAO.findOne("U001");
		
		assertNotNull("Entity object is not Null", UnitEntity);
		assertEquals(UnitEntity.getUnitName(),"Metres");
	}

	/*
	 * Method - findAllUnitTest()
	 * Using UnitDAO to fetch all the entities 
	 * Assert that the list is Not null 
	 * Assert that the count of entities matches to --> 3
	 */
			
	@Test
	public void findAllUnitTest() {
		// Your Code Here
		List<UnitEntity> entities = unitDAO.findAll();
		assertNotNull("Entites are not null", entities);
		assertEquals(entities.size(), 5);
		
	}
	
}
