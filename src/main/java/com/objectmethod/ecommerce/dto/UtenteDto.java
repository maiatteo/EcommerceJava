package com.objectmethod.ecommerce.dto;

import lombok.Data;

@Data
public class UtenteDto {
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private String username;
	private String password;
	private Boolean amministratore;
	private Long idIndirizzo;
	
	
	
	
}
