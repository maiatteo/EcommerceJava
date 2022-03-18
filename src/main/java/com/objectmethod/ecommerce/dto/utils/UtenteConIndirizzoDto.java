package com.objectmethod.ecommerce.dto.utils;

import com.objectmethod.ecommerce.dto.UtenteDto;

import lombok.Data;


 @Data
public class UtenteConIndirizzoDto extends UtenteDto{

	private String via;
	private String provincia;
	private String citta;
	private String regione;
}
