package com.objectmethod.ecommerce.dto;

import lombok.Data;
@Data
public class IndirizzoDto {
	private Long id;
	private String via;
	private String citta;
	private String provincia;
	private String regione;
	private Long idNegozio;
	private Long idUtenti;
}
