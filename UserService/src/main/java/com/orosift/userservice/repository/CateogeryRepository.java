package com.orosift.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orosift.userservice.model.Categories;

@Repository
public interface CateogeryRepository extends JpaRepository<Categories, Character>{

}
