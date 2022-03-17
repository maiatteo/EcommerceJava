package com.objectmethod.ecommerce.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="carrelli")
public class Carrello {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	@JoinColumn(name ="id_prodotto")
	private List<Prodotti> prodotti;
	
	@Column(name = "quantita")
	private Long quantita;
	
	@JoinColumn(name ="id_utente")
	private Utente utente;

}
