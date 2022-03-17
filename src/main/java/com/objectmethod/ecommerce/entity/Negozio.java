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
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "negozi")
public class Negozio {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="codice")
	private String codice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_indirizzo")
	private Indirizzo indirizzoNeg;
	

}
