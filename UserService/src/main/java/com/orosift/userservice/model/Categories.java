package com.orosift.userservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Entity
@Table(name = "categories")
@Data
@JsonInclude(Include.NON_NULL)
public class Categories {

	@Id
	@Column(name = "CategoryId")
	Character categoryId;

	@Column(name = "CategoryName")
	String categoryName;

	@Column(name = "ImagePath")
	String imagePath;

}
