package com.objectmethod.ecommerce.dto.utils;

import java.util.List;

import lombok.Data;

@Data
public class StoresResponse {
	
	private List<StoresResponseSing> store;
	private String message;

}
