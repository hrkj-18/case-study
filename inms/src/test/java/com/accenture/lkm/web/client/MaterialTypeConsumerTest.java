package com.accenture.lkm.web.client;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accenture.lkm.exceptions.MicroServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/WEB-INF/ims-servlet.xml","classpath:/WEB-INF/ims-root-ctx.xml"})
public class MaterialTypeConsumerTest {

	@Autowired
	private MaterialTypeConsumer materialTypeConsumer;
	
	@Test
	public void testMaterialConsumer() throws MicroServiceException {
		assertNotNull("Object not null",materialTypeConsumer);
	}
	
	@Test
	public void testGetMaterialTypeBeanList() throws MicroServiceException {
		Assert.assertEquals("Size does not match!",7,materialTypeConsumer.getMaterialTypeBeanList().size());
	}
	
	@Test
	public void testGetCategoryTypeMap() throws MicroServiceException {
		Assert.assertEquals("Size does not match!",7,materialTypeConsumer.getCategoryTypeMap().size());
	}
	
	@Test
	public void testGetCategoryTypeMapName() throws MicroServiceException {
		Assert.assertEquals("Size does not match!","Silk",materialTypeConsumer.getCategoryTypeMap().get("T001"));
	}			
}


