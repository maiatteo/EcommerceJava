package com.objectmethod.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;
@Entity
@Data
@Table(name="prodotti")
public class Prodotto {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="nome")
	private String nome;
	@Column(name="peso")
	private Double peso;
	@Column(name="quantita")
	private Integer quantita;
	@Column(name="codice")
	private String codice;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="idcarrello")
	private Carrello carrello;
	
	
}
