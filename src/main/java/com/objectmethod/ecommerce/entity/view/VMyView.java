package com.objectmethod.ecommerce.entity.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name="my_view")
public class VMyView {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String id;
	
	@Column(name="quantita")
	private Integer quantita;

	@Column(name="prezzo")
	private Double prezzo;

	@Column(name="id_carrello")
	private Integer idCarrello;
}
