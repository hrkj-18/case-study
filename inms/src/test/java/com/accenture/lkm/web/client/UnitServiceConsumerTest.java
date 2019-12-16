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
public class UnitServiceConsumerTest {

	@Autowired
	private UnitServiceConsumer unitServiceConsumer;
	
	@Test
	public void testUnitConsumer() throws MicroServiceException {
		assertNotNull("Object not null",unitServiceConsumer);
	}
	
	@Test
	public void testGetUnitBeanList() throws MicroServiceException {
		Assert.assertEquals("Size does not match!",5,unitServiceConsumer.getUnitBeanList().size());
	}
	
	@Test
	public void testGetUnitMap() throws MicroServiceException {
		Assert.assertEquals("Size does not match!",5,unitServiceConsumer.getUnitMap().size());
	}
	
	@Test
	public void testGetUnitMapName() throws MicroServiceException {
		Assert.assertEquals("Size does not match!","Metres",unitServiceConsumer.getUnitMap().get("U001"));
	}	
}


