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
public class MaterialCategoryConsumerTest {

	@Autowired
	private MaterialCategoryConsumer materialCategoryConsumer;
	
	@Test
	public void testVendorConsumer() throws MicroServiceException {
		assertNotNull("Object not null",materialCategoryConsumer);
	}
	
	@Test
	public void testGetMaterialCategoryBeanList() throws MicroServiceException {
		Assert.assertEquals("Size does not match!",3,materialCategoryConsumer.getMaterialCategoryBeanList().size());
	}
	
	@Test
	public void testGetCategoryMap() throws MicroServiceException {
		Assert.assertEquals("Size does not match!",3,materialCategoryConsumer.getCategoryMap().size());
	}
	
	@Test
	public void testGetCategoryMapName() throws MicroServiceException {
		Assert.assertEquals("Size does not match!","Thread",materialCategoryConsumer.getCategoryMap().get("C001"));
	}		
}


