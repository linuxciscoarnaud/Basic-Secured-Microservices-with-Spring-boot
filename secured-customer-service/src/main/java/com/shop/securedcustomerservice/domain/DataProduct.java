/**
 * 
 */
package com.shop.securedcustomerservice.domain;

import java.math.BigDecimal;

/**
 * @author Arnaud
 *
 */

public class DataProduct {

	private String productId;
	private String name;
	private String description;
	private BigDecimal unitPrice;
	private Long unitsInStock;
	private DataCategory category;
	
	public DataProduct() {
		// TODO Auto-generated constructor stub
	}
	
	public DataProduct(String productId, String name, String description, BigDecimal unitPrice, DataCategory category) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.category = category;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public DataCategory getCategory() {
		return category;
	}

	public void setCategory(DataCategory category) {
		this.category = category;
	}

	public Long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(Long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
}
