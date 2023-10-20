package com.orosift.userservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Entity
@Table(name = "products")
@Data
@JsonInclude(Include.NON_NULL)
public class Products {

	@Id
	@Column(name = "ProductId")
	String productId;

	@Column(name = "CategoryId")
	Character categoryId;

	@Column(name = "ProductName")
	String productName;

	@Column(name = "ProductPrice")
	String productPrice;

	@Column(name = "ProductDescription")
	String productDescription;

	@Column(name = "ViewCount")
	Integer viewCount;

	@Column(name = "ImagePath")
	String imagePath;

}
