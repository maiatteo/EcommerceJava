package com.objectmethod.ecommerce.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="e_acquisti")
@Data
public class Acquisto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "data")
	private Date data;
	
	@OneToOne
	@JoinColumn(name ="id_carrello")
	private Carrello carrello;
	
	@Column(name="prezzo")
	private Double prezzo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_utente")
	private Utente utente;
}
