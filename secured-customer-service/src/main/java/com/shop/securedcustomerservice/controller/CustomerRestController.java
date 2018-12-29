/**
 * 
 */
package com.shop.securedcustomerservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.securedcustomerservice.config.RestTemplateBuilder;
import com.shop.securedcustomerservice.domain.Customer;
import com.shop.securedcustomerservice.domain.DataCategory;
import com.shop.securedcustomerservice.domain.DataProduct;
import com.shop.securedcustomerservice.exception.CustomerDoesNotExistsException;
import com.shop.securedcustomerservice.service.CustomerServiceService;
import com.shop.securedcustomerservice.util.Params;

/**
 * @author Arnaud
 *
 */

@RestController
@PropertySource({"classpath:application.properties"})
@RequestMapping("consumer")
public class CustomerRestController {

	@Autowired
	private CustomerServiceService customerServiceService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Params params = new Params();
	
	// All Get
	
	@GetMapping("/product/{productId}/customer/{customerId}")
	public DataProduct requestProductByProductId(@PathVariable String productId, 
			@PathVariable String customerId) throws CustomerDoesNotExistsException {
		
		String producerBaseUrl = params.getProducerBaseUrl();
		
		DataProduct response = new DataProduct();
		ResponseEntity<DataProduct> responseEntity;
		
		Customer customer = customerServiceService.getCustomerByCustomerId(customerId);
		if (customer != null) {
			Map<String, String> uriVariables = new HashMap<>();
			uriVariables.put("productId", productId);
			
			responseEntity = RestTemplateBuilder.securityRestTemplateBuilder("user", "12345")
					.getForEntity(
						 producerBaseUrl + "product/{productId}",
						 DataProduct.class,
						 uriVariables);
			
			response = responseEntity.getBody();
		} else {
			throw new CustomerDoesNotExistsException("Message from the super class");
		}
		
		return new DataProduct(response.getProductId(),
				response.getName(),
				response.getDescription(),
				response.getUnitPrice(),
				response.getCategory());
	}
	
	
	@GetMapping("/product/products/customer/{customerId}")
	public List<DataProduct> requestAllProducts(@PathVariable String customerId) throws CustomerDoesNotExistsException {
		
		String producerBaseUrl = params.getProducerBaseUrl();
		
		ResponseEntity<List<DataProduct>> responseEnties = null;
		List<DataProduct> response;
		
		Customer customer = customerServiceService.getCustomerByCustomerId(customerId);
		
		if (customer != null) {
			
			responseEnties = RestTemplateBuilder.securityRestTemplateBuilder("user", "12345")
					.exchange(
							producerBaseUrl + "product/products",
							HttpMethod.GET,
							null,
							new ParameterizedTypeReference<List<DataProduct>>(){});		
		} else {
			throw new CustomerDoesNotExistsException("Message from the super class");
		}
		
		response = responseEnties.getBody();
		
		return response;
	}
	
	
	// All Post
	
	@PostMapping("/product/add/customer/{customerId}")
	public void requestAddProduct(@RequestBody DataProduct daProduct, 
			@PathVariable String customerId) throws CustomerDoesNotExistsException {
		
		String producerBaseUrl = params.getProducerBaseUrl();
		
		Customer customer = customerServiceService.getCustomerByCustomerId(customerId);
		
		if (customer != null) {	
			
			RestTemplateBuilder.securityRestTemplateBuilder("user", "12345")
			        .postForEntity(
			        		producerBaseUrl + "product/add",
			        		daProduct,
			        		DataProduct.class);
		} else {
			throw new CustomerDoesNotExistsException("Message from the super class");
		}
	}
	
	@PostMapping("/category/add/customer/{customerId}")
	public void requestAddCategory(@RequestBody DataCategory daCategory,
			@PathVariable String customerId) {
		
		String producerBaseUrl = params.getProducerBaseUrl();
		
		Customer customer = customerServiceService.getCustomerByCustomerId(customerId);
		
		if (customer != null) {	
			
			RestTemplateBuilder.securityRestTemplateBuilder("user", "12345")
			       .postForEntity(
			    	   producerBaseUrl + "category/add",
					   daCategory,
					   DataCategory.class);
		}
	}
	
	
	// All Put
	
	@PutMapping("/update/product/{productId}/customer/{customerId}")
	public void requestUpdateProduct(@PathVariable("productId") String productId, 
			@PathVariable("customerId") String customerId, 
			@RequestBody DataProduct daProduct) {
		
		String producerBaseUrl = params.getProducerBaseUrl();
		
		Customer customer = customerServiceService.getCustomerByCustomerId(customerId);
		
		if (customer != null) {	
			Map<String, String> uriVariables = new HashMap<>();
			uriVariables.put("productId", productId);
			
			RestTemplateBuilder.securityRestTemplateBuilder("user", "12345")
			        .put(
			        	producerBaseUrl + "product/{productId}", 
					    daProduct, 
					    uriVariables);
		}
	}
	
	
	@PutMapping("/update/product/category/{categoryId}/customer/{customerId}")
	public void requestUpdateCategory(@PathVariable("categoryId") String categoryId, 
			@PathVariable("customerId") String customerId, 
			@RequestBody DataCategory dataCategory) {
		
		String producerBaseUrl = params.getProducerBaseUrl();
		
		Customer customer = customerServiceService.getCustomerByCustomerId(customerId);
		
		if (customer != null) {	
			Map<String, String> uriVariables = new HashMap<>();
			uriVariables.put("categoryId", categoryId);
			
			RestTemplateBuilder.securityRestTemplateBuilder("user", "12345")
			        .put(
			        	producerBaseUrl + "product/category/{categoryId}", 
					    dataCategory, 
					    uriVariables);
		}
	}
	
	
	// All Delete
	
	@DeleteMapping("/delete/product/{productId}/customer/{customerId}")
	public void requestDeleteProduct(@PathVariable("productId") String productId, 
			@PathVariable("customerId") String customerId) {
		
		String producerBaseUrl = params.getProducerBaseUrl(); 
		
		Customer customer = customerServiceService.getCustomerByCustomerId(customerId);
		
		if (customer != null) {
			Map<String, String> uriVariables = new HashMap<>();
			uriVariables.put("productId", productId);
			
			RestTemplateBuilder.securityRestTemplateBuilder("user", "12345")
			        .delete(
			        		producerBaseUrl + "product/{productId}",
			        		uriVariables);
		}
	}
}
