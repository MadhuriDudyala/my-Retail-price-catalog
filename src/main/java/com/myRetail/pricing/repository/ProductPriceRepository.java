/**
 * 
 */
package com.myRetail.pricing.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.myRetail.pricing.model.ProductPriceInfo;

/**
 * @author owner
 *
 */
public interface ProductPriceRepository extends PagingAndSortingRepository<ProductPriceInfo, Long> {
}
