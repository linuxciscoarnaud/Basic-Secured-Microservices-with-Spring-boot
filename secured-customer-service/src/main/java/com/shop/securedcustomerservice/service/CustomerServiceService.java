/**
 * 
 */
package com.shop.securedcustomerservice.service;

import com.shop.securedcustomerservice.domain.Customer;

/**
 * @author Arnaud
 *
 */


public interface CustomerServiceService {

	Customer getCustomerByCustomerId(String customerId);
	void addCustomer(Customer customer);
	Customer getCustomerByCredentials(String userName, String password);
}
