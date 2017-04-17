/**
 * 
 */
package com.myRetail.pricing.service;

import java.util.List;

import com.myRetail.pricing.model.ProductPriceInfo;

/**
 * @author owner
 *
 */
public interface ProductPriceService {
	
	public ProductPriceInfo getProductPrice( Long id );
	
	public void saveProductPrice( ProductPriceInfo productPriceInfo );
	
	public List<ProductPriceInfo> getAllProducts();

}
