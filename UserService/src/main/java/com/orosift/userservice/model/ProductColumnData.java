package com.orosift.userservice.model;

import lombok.Data;

@Data
public class ProductColumnData {
	
    private String productId;
    private Character categoryId;
    private String productName;
    private String productPrice;

}
