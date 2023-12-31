package com.orosift.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orosift.userservice.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, String>{
	

}
