package com.myRetail.pricing.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductPriceInfo {
	
	@Id
	private long id;
		
	private double value;
	
	private String currency_code;

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * @return the currency_code
	 */
	public String getCurrency_code() {
		return currency_code;
	}

	/**
	 * @param currency_code the currency_code to set
	 */
	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductPriceInfo [id=" + id + ", value=" + value + ", currency_code=" + currency_code + "]";
	}
	
}
