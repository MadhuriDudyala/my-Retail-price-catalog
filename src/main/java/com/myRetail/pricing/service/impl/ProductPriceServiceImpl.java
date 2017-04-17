/**
 * 
 */
package com.myRetail.pricing.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myRetail.pricing.model.ProductPriceInfo;
import com.myRetail.pricing.repository.ProductPriceRepository;
import com.myRetail.pricing.service.ProductPriceService;

/**
 * @author owner
 *
 */
@Service
public class ProductPriceServiceImpl implements ProductPriceService {
	
	@Autowired
	private ProductPriceRepository productPriceRepository;

	public ProductPriceInfo getProductPrice(Long id) {		
		return productPriceRepository.findOne( id );
	}

	@Override
	public void saveProductPrice(ProductPriceInfo productPriceInfo) {
		productPriceRepository.save( productPriceInfo );		
	}

	@Override
	public List<ProductPriceInfo> getAllProducts() {
		Iterable<ProductPriceInfo> iterable = productPriceRepository.findAll();
		return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
	}

}
