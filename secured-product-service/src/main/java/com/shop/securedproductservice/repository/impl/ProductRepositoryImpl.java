/**
 * 
 */
package com.shop.securedproductservice.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.securedproductservice.domain.Category;
import com.shop.securedproductservice.domain.Product;
import com.shop.securedproductservice.repository.ProductRepository;

/**
 * @author Arnaud
 *
 */

@Transactional
@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@PersistenceContext	
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.repository.ProductRepository#getProductByProductId(java.lang.String)
	 */
	@Override
	public Product getProductByProductId(String productId) {
		// TODO Auto-generated method stub
		Product product = entityManager.find(Product.class, productId);
		return product;
	}

	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.repository.ProductRepository#getAllProducts()
	 */
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("from Product pr");
		return req.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.repository.ProductRepository#getAllCategories()
	 */
	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("from Category ct");
		return req.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.repository.ProductRepository#getCategory(java.lang.String)
	 */
	@Override
	public Category getCategory(String categoryId) {
		// TODO Auto-generated method stub
		Category category = entityManager.find(Category.class, categoryId);
		return category;
	}

	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.repository.ProductRepository#addProduct(com.shop.securedproductservice.domain.Product)
	 */
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		Query req1 = entityManager.createQuery("select cat from Category cat where cat.name = :y ");
		req1.setParameter("y", product.getCategory().getName());
		List<Category> categories = req1.getResultList();
		if (categories.size() != 0) {
			product.setCategory(categories.get(0));
			entityManager.persist(product);
		}
		else {
			Category newCategory = new Category();
			newCategory.setName(product.getCategory().getName());
			addCategory(newCategory);
			
			Query req2 = entityManager.createQuery("select cat from Category cat where cat.name = :y ");
			req2.setParameter("y", product.getCategory().getName());
			product.setCategory((Category)req1.getResultList().get(0));
			
			entityManager.persist(product);			 		
		}
	}

	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.repository.ProductRepository#addCategory(com.shop.securedproductservice.domain.Category)
	 */
	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("select cat from Category cat where cat.name = :y ");
		req.setParameter("y", category.getName());
		List<Category> categories = req.getResultList();
		if (categories.size() == 0) {
			entityManager.persist(category);
		}	
	}

	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.repository.ProductRepository#updateProduct(java.lang.String, com.shop.securedproductservice.domain.Product)
	 */
	@Override
	public void updateProduct(String productId, Product product) {
		// TODO Auto-generated method stub
		Product productWithNewInfos = entityManager.find(Product.class, productId);
		if (productWithNewInfos != null) {
			productWithNewInfos.setName(product.getName());
			productWithNewInfos.setUnitPrice(product.getUnitPrice());
			productWithNewInfos.setDescription(product.getDescription());
			productWithNewInfos.setUnitsInStock(product.getUnitsInStock());
		}
		entityManager.merge(productWithNewInfos);
	}

	/* (non-Javadoc)
	 * @see com.shop.securedproductservice.repository.ProductRepository#updateCategory(java.lang.String, com.shop.securedproductservice.domain.Category)
	 */
	@Override
	public void updateCategory(String categoryId, Category category) {
		// TODO Auto-generated method stub
		Category categoryWithNewInfos = entityManager.find(Category.class, categoryId);
		if (categoryWithNewInfos != null) {
			categoryWithNewInfos.setName(category.getName());
		}
		entityManager.merge(categoryWithNewInfos);
	}

	@Override
	public void deleteProduct(String productId) {
		// TODO Auto-generated method stub
		Product productToBeDeleted = entityManager.find(Product.class, productId);
		if (productToBeDeleted != null) {
			entityManager.remove(productToBeDeleted);
		}
	}
	
}
