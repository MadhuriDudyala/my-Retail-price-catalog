/**
 * 
 */
package com.myRetail.pricing.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myRetail.pricing.model.ProductPriceInfo;
import com.myRetail.pricing.service.ProductPriceService;

/**
 * @author owner
 *
 */
@RestController
public class ProductPriceController {

	public static final Logger logger = LoggerFactory.getLogger(ProductPriceController.class);

	@Autowired
	private ProductPriceService productPriceService;

	/**
	 * Get the product price information
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/price/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getProductPriceInfo( @PathVariable("id") long id ) {
		logger.info(" fetching the product price with id ", id );
		ProductPriceInfo productPriceInfo = productPriceService.getProductPrice( id );
		return new ResponseEntity<ProductPriceInfo>( productPriceInfo , HttpStatus.OK);
	}

	@RequestMapping(value="/price/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProductPriceInfo(@PathVariable("id") long id, @RequestBody Map<String, Object> productMap) { 		
		ProductPriceInfo productPriceInfo = new ProductPriceInfo();
		productPriceInfo.setValue( (Double) productMap.get("value") );
		productPriceInfo.setCurrency_code( (String) productMap.get("currency_code") );		
		productPriceInfo.setId(id);
		productPriceService.saveProductPrice(productPriceInfo);		
		return new ResponseEntity<ProductPriceInfo>( productPriceInfo , HttpStatus.OK);
	}
	
	// Below method is for to insert some test records in the database 	
	@RequestMapping(method = RequestMethod.POST)	
	public ResponseEntity<?> createProductPriceInfo(@RequestBody Map<String, Object> productMap){

		ProductPriceInfo productPriceInfo = new ProductPriceInfo();
		productPriceInfo.setId( (Integer) productMap.get("id") );
		productPriceInfo.setValue( (Double) productMap.get("value") );
		productPriceInfo.setCurrency_code( (String) productMap.get("currency_code") );
		productPriceService.saveProductPrice(productPriceInfo);		
		return new ResponseEntity<ProductPriceInfo>( productPriceInfo , HttpStatus.CREATED);
	}

	@RequestMapping(value = "/price", method = RequestMethod.GET)
	public ResponseEntity<?> getAllProducts() {		
		List<ProductPriceInfo> productPriceInfos = productPriceService.getAllProducts();
		return new ResponseEntity<List<ProductPriceInfo>>( productPriceInfos , HttpStatus.OK);
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<Object> handleThrowable(final Throwable ex) {
		ex.printStackTrace();
		return new ResponseEntity<Object>("Unable to process request.", HttpStatus.INTERNAL_SERVER_ERROR);
	}	
}
