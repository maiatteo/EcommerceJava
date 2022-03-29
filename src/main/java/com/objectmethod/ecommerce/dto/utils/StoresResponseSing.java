package com.objectmethod.ecommerce.dto.utils;

import java.util.List;

import com.objectmethod.ecommerce.entity.StoreProva;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class StoresResponseSing{
	
	private List<StoreProva> giacenza;
	private String storeCode;

	
}
