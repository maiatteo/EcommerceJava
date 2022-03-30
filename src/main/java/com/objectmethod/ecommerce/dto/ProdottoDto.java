package com.objectmethod.ecommerce.dto;

import java.util.List;

import lombok.Data;
@Data
public class ProdottoDto {

	private Long id;
	private String nome;
	private Double peso;
	private String codice;
	private Double prezzo;
	private List<Long> idCarrello;
	
}
