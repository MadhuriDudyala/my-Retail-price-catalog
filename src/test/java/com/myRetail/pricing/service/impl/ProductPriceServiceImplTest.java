/**
 * 
 */
package com.myRetail.pricing.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.myRetail.pricing.model.ProductPriceInfo;
import com.myRetail.pricing.repository.ProductPriceRepository;
import com.myRetail.pricing.service.ProductPriceService;

/**
 * @author owner
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductPriceServiceImplTest {

	@Mock
	private ProductPriceRepository productPriceRepository;
	
	@InjectMocks
	private ProductPriceService productPriceService = new ProductPriceServiceImpl();

	@Test
	public void testGetProductPrice()
	{
		ProductPriceInfo productPriceInfo = new ProductPriceInfo();
		productPriceInfo.setId(123L);
		productPriceInfo.setValue(13.49);
		productPriceInfo.setCurrency_code("USD");
		
		Mockito.when(productPriceRepository.findOne(12L)).thenReturn(productPriceInfo);		
		ProductPriceInfo retrivedProductPriceInfo = productPriceService.getProductPrice(12L);		
		Assert.assertEquals(productPriceInfo, retrivedProductPriceInfo);		
	}
}
