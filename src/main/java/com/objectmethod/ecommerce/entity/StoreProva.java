package com.objectmethod.ecommerce.entity;

import java.math.BigInteger;

import lombok.Data;

@Data
public class StoreProva {

	private Long id;
	private String codeProdotto;
	private String codeNegozio;
	private BigInteger giacenze;
}
