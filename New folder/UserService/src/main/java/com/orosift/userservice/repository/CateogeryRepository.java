package com.orosift.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orosift.userservice.model.Categories;

@Repository
public interface CateogeryRepository extends JpaRepository<Categories, Character>{

	
	//@Query(value = "SELECT category_id,category_name FROM categories", nativeQuery = true)
    //List<String> fetchColumnData();
	
	
//	@Query(value = "SELECT categoryId, categoryName FROM categories", nativeQuery = true)
//    List<Categories> fetchColumnData();
}
