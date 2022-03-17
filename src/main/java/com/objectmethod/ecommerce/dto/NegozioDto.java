package com.objectmethod.ecommerce.dto;

import lombok.Data;

@Data
public class NegozioDto {

	private Long id;
	private String nome;
	private String codice;
	private Long idIndirizzo;
	
}
