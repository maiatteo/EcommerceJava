package com.objectmethod.ecommerce;

import java.util.List;

import com.objectmethod.ecommerce.entity.StoreProva;

import lombok.Data;

@Data
public class ApiGiacenzeResponse {
private String message;
private List<StoreProva> giacenza;
	
}
