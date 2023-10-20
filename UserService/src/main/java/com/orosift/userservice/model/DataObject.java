package com.orosift.userservice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class DataObject {

	private String TYPE;
	private List<ProductColumnData> FeaturedProducts;
	private List<CategoiesColumnData> Categories;
//	private List<String> FeaturedProduct;
//	private List<String> Categorie;

}