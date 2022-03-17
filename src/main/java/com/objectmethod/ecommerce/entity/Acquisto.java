package com.objectmethod.ecommerce.entity;


import java.util.Date;

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
@Table(name="acquisto")
@Data
public class Acquisto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date data;
	@OneToOne
	private Carrello carrello;
	
	private Double prezzo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="idutente")
	private Utente utente;
}
