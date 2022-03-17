package com.objectmethod.ecommerce.dto;

import lombok.Data;
@Data
public class ProdottoDto {

	private Long id;
	private String nome;
	private Double peso;
	private Integer quantita;
	private String codice;
	private Double prezzo;
	private Long idCarrello;
	
}
