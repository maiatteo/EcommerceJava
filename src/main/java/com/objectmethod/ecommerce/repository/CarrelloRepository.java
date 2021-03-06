package com.objectmethod.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.objectmethod.ecommerce.dto.AcquistoDto;
import com.objectmethod.ecommerce.dto.CarrelloDto;
import com.objectmethod.ecommerce.dto.ProdottiCarrelloDto;
import com.objectmethod.ecommerce.entity.Carrello;
import com.objectmethod.ecommerce.entity.ProdottiCarrello;
import com.objectmethod.ecommerce.entity.Utente;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello, Long>{
	
	@Modifying
	@Query(value = "insert into e_carrelli(id_utente) values (?1)",nativeQuery=true)
	public void creaCarrello(Long idUtente);
	
	@Query(value="SELECT id FROM e_carrelli WHERE id_utente = ?1 ORDER BY id DESC LIMIT 1", nativeQuery = true)
	public Long getLastCarrello(Long idUtente);
	
}
