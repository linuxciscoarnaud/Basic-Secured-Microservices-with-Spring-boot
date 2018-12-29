/**
 * 
 */
package com.shop.securedcustomerservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.securedcustomerservice.domain.Customer;
import com.shop.securedcustomerservice.repository.CustomerServiceRepository;
import com.shop.securedcustomerservice.service.CustomerServiceService;

/**
 * @author Arnaud
 *
 */

@Service
@Transactional
public class CustomerServiceServiceImpl implements CustomerServiceService {

	@Autowired
	private CustomerServiceRepository customerServiceRepository;
	
	/* (non-Javadoc)
	 * @see com.shop.customerservice.service.CustomerServiceService#getCustomerByCustomerId(java.lang.String)
	 */
	@Override
	public Customer getCustomerByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return customerServiceRepository.getCustomerByCustomerId(customerId);
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerServiceRepository.addCustomer(customer);
	}

	@Override
	public Customer getCustomerByCredentials(String userName, String password) {
		// TODO Auto-generated method stub
		return customerServiceRepository.getCustomerByCredentials(userName, password);
	}
}
