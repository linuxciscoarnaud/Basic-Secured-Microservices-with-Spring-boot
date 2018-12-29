/**
 * 
 */
package com.shop.securedproductservice.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.shop.securedproductservice.domain.Category;
import com.shop.securedproductservice.domain.Product;

/**
 * @author Arnaud
 *
 */

public interface ProductService {

	Product getProductByProductId(String productId);
	List<Product> getAllProducts();
	List<Category> getAllCategories();
	Category getCategory(String categoryId);
	void addProduct(Product product);
	void addCategory(Category category);
	void updateProduct(String productId, Product product);
	void updateCategory(String categoryId, Category category);
	void deleteProduct(String productId);
}
