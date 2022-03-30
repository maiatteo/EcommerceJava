package com.objectmethod.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.objectmethod.ecommerce.entity.Prodotto;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long>{

	
	@Modifying
	@Query(value = "INSERT INTO e_carrelloprodotti(id_prodotti, id_carrello, quantita) VALUES (?1, ?2, ?3)", nativeQuery = true)
	public void aggiungiAlCarrello(Long idProdotto, Long idCarrello, Integer quantita);
	
	@Query(value = "select from e_prodotti where nome like :name", nativeQuery = true)
	public List<Prodotto> findByNsme(String name);
	
}
