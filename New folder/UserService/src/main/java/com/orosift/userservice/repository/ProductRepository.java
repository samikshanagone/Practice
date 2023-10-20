package com.orosift.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orosift.userservice.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, String>{
	
	//@Query(value = "SELECT product_id,category_id,product_name,product_price FROM products", nativeQuery = true)
    //List<String> fetchColumnData();
	
//	@Query(value = "SELECT productId,categoryId,productName FROM products", nativeQuery = true)
//	List<ProductColumnData> fetchColumnData();
	
//    @Query(value = "SELECT new com.orosift.userservice.model.ProductColumnData(p.productId, p.categoryId, p.productName) FROM products p", nativeQuery = true)
//    List<ProductColumnData> fetchColumnData();
	
	
}
