/**
 * 
 */
package com.shop.securedcustomerservice.util;

/**
 * @author Arnaud
 *
 */

public class Params {

	private final String IDSOURCE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private int idsLength = 10;
	private String producerBaseUrl = "http://localhost:8080/producer/"; 
	
	public int getIdsLength() {
		return idsLength;
	}
	public void setIdsLength(int idsLength) {
		this.idsLength = idsLength;
	}
	public String getIDSOURCE() {
		return IDSOURCE;
	}
	public String getProducerBaseUrl() {
		return producerBaseUrl;
	}
	public void setProducerBaseUrl(String producerBaseUrl) {
		this.producerBaseUrl = producerBaseUrl;
	}
}
