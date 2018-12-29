/**
 * 
 */
package com.shop.securedcustomerservice.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.securedcustomerservice.domain.Customer;
import com.shop.securedcustomerservice.repository.CustomerServiceRepository;

/**
 * @author Arnaud
 *
 */
@Repository
@Transactional
public class CustomerServiceRepositoryImpl implements CustomerServiceRepository {

	@PersistenceContext
	public EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.shop.customerservice.repository.CustomerServiceRepository#getCustomerByCustomerId(java.lang.String)
	 */
	@Override
	public Customer getCustomerByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		Customer customer = entityManager.find(Customer.class, customerId);
		return customer ;
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		entityManager.persist(customer);
	}

	@Override
	public Customer getCustomerByCredentials(String userName, String password) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		Query req = entityManager.createQuery("select cus from Customer cus where cus.userName = :userName and cus.password = :password");
		req.setParameter("userName", userName);
		req.setParameter("password", password);
		List<Customer> customers = req.getResultList();
		if (customers.size() != 0) {
			customer = customers.get(0);
		}
		return customer;
	}
}
