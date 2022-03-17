package com.objectmethod.ecommerce.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="e_utenti")
public class Utente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
	@Column(name="email")
	private String email;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="amministratore")
	private Boolean amministratore;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_indirizzo")
	private Indirizzo indirizzoUte;
	
	@OneToOne
	@JoinColumn(name ="idcarrello")
	private Carrello carrello;
	
	@OneToMany
	@JoinColumn(name ="idacquisto")
	private List<Acquisto> acquisti;
}
