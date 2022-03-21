package com.objectmethod.ecommerce.dto;

import java.util.Date;

import lombok.Data;


@Data
public class AcquistoDto {
	private Long id;
	private Date data;
	private Double prezzo;
	private Long idCarrello;
	private Long idUtente;
}
