/**
 * 
 */
package com.shop.securedcustomerservice.repository;

import com.shop.securedcustomerservice.domain.Customer;

/**
 * @author Arnaud
 *
 */


public interface CustomerServiceRepository {

	Customer getCustomerByCustomerId(String customerId);
	void addCustomer(Customer customer);
	Customer getCustomerByCredentials(String userName, String password);
}
