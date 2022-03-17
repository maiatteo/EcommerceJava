package com.objectmethod.ecommerce.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "indirizzi")
public class Indirizzo {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(name="via")
	private String via;
	
	@Column(name="citta")
	private String citta;
	
	@Column(name="provincia")
	private String provincia;
	
	@Column(name="regione")
	private String regione;
	
	@OneToMany(mappedBy = "indirizzoNeg", fetch = FetchType.LAZY)
	private List<Negozio> negozi;
	
	@OneToMany(mappedBy = "indirizzoUte", fetch = FetchType.LAZY)
	private List<Utente> utenti;
	

}
