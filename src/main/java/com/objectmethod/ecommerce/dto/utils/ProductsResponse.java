package com.objectmethod.ecommerce.dto.utils;

import java.util.List;

import lombok.Data;

@Data
public class ProductsResponse {
	
	private List<ProductsResponseSing> product;
	private String message;

}
