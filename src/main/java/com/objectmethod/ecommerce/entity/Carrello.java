package com.objectmethod.ecommerce.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="e_carrelli")
public class Carrello {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Transient
	private Double prezzo;
	
	@OneToOne(mappedBy ="carrello")
	@JoinColumn(name ="id_utente")
	private Utente utente;

	//@OneToOne(mappedBy ="carrello")
	//private Acquisto acquisto;

	@ManyToMany()
    @JoinTable(
            name = "e_carrelloprodotti",
            joinColumns = @JoinColumn(name = "id_prodotti"),
            inverseJoinColumns = @JoinColumn(name = "id_carrello"))
    private List<Prodotto> prodotti;
	
}
