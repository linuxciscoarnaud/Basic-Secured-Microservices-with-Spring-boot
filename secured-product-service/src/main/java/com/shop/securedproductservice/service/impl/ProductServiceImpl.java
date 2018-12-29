/**
 * 
 */
package com.shop.securedproductservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.securedproductservice.domain.Category;
import com.shop.securedproductservice.domain.Product;
import com.shop.securedproductservice.repository.ProductRepository;
import com.shop.securedproductservice.service.ProductService;

/**
 * @author Arnaud
 *
 */

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.service.ProductService#getProductByProductId(java.lang.String)
	 */
	@Override
	public Product getProductByProductId(String productId) {
		// TODO Auto-generated method stub
		return productRepository.getProductByProductId(productId);
	}

	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.service.ProductService#getAllProducts()
	 */
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.getAllProducts();
	}

	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.service.ProductService#getAllCategories()
	 */
	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return productRepository.getAllCategories();
	}

	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.service.ProductService#getCategory(java.lang.String)
	 */
	@Override
	public Category getCategory(String categoryId) {
		// TODO Auto-generated method stub
		return productRepository.getCategory(categoryId);
	}

	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.service.ProductService#addProduct(com.shop.securedproductservice.domain.Product)
	 */
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.addProduct(product);
	}

	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.service.ProductService#addCategory(com.shop.securedproductservice.domain.Category)
	 */
	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		productRepository.addCategory(category);
	}

	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.service.ProductService#updateProduct(java.lang.String, com.shop.securedproductservice.domain.Product)
	 */
	@Override
	public void updateProduct(String productId, Product product) {
		// TODO Auto-generated method stub
		productRepository.updateProduct(productId, product);
	}

	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.service.ProductService#updateCategory(java.lang.String, com.shop.securedproductservice.domain.Category)
	 */
	@Override
	public void updateCategory(String categoryId, Category category) {
		// TODO Auto-generated method stub
		productRepository.updateCategory(categoryId, category);
	}

	@Override
	public void deleteProduct(String productId) {
		// TODO Auto-generated method stub
		productRepository.deleteProduct(productId);
	}
}
