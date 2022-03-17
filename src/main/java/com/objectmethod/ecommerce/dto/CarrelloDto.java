package com.objectmethod.ecommerce.dto;

import lombok.Data;
@Data
public class CarrelloDto {
	private Long id;
	private long idProdotti;
	private Long quantita;
	private Long idUtente;
}
