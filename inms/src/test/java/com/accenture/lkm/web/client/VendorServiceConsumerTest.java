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
public class VendorServiceConsumerTest {

	@Autowired
	private VendorServiceConsumer vendorServiceConsumer;
	
	@Test
	public void testVendorConsumer() throws MicroServiceException {
		assertNotNull("Object not null",vendorServiceConsumer);
	}
	
	@Test
	public void testGetVendorBeanList() throws MicroServiceException {
		Assert.assertEquals("Size matches!",5,vendorServiceConsumer.getVendorBeanList().size());
	}
	
	@Test
	public void testGetVendorMap() throws MicroServiceException {
		Assert.assertEquals("Size matches!",5,vendorServiceConsumer.getVendorBeanMap().size());
	}
	
	@Test
	public void testGetVendorMapName() throws MicroServiceException {
		Assert.assertEquals("Size matches!","Only Vimal",vendorServiceConsumer.getVendorBeanMap().get("V001").getVendorName());
	}		
}


