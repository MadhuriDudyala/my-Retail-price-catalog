/**
 * 
 */
package com.myRetail.pricing.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doAnswer;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myRetail.pricing.model.ProductPriceInfo;
import com.myRetail.pricing.service.ProductPriceService;

/**
 * @author owner
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ProductPriceController.class)
public class ProductPriceControllerTest {
	
    @Autowired
    private MockMvc mvc;
    
	@MockBean
	private ProductPriceService productPriceService;
	
	@Autowired private ObjectMapper mapper;

	@Test
	public void testGetProductPriceInfo() throws Exception
	{
		ProductPriceInfo productPriceInfo = new ProductPriceInfo();
		productPriceInfo.setId(123L);
		productPriceInfo.setValue(13.49);
		productPriceInfo.setCurrency_code("USD");
		
		given(this.productPriceService.getProductPrice(1L))
		.willReturn(productPriceInfo);
				
		this.mvc.perform(get("/price/12").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());		
	}
	
	@Test
	public void testUpdateProductPriceInfo() throws Exception
	{
		ProductPriceInfo productPriceInfo = new ProductPriceInfo();
		productPriceInfo.setId(123L);
		productPriceInfo.setValue(13.49);
		productPriceInfo.setCurrency_code("USD");
		
		doAnswer(new Answer<Void>() {
			@Override
		    public Void answer(final InvocationOnMock invocation) {
				return null;
			}
		}).when(this.productPriceService).saveProductPrice(productPriceInfo);
		
		String json = mapper.writeValueAsString(productPriceInfo);
		
		this.mvc.perform(put("/price/12")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
