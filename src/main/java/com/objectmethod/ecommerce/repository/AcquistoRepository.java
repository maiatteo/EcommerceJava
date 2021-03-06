package com.objectmethod.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.objectmethod.ecommerce.dto.AcquistoDto;
import com.objectmethod.ecommerce.entity.Acquisto;

@Repository
public interface AcquistoRepository  extends JpaRepository<Acquisto, Long>{

	@Query(value="SELECT * FROM e_acquisti WHERE id_utente = ?1", nativeQuery = true)
	List<Acquisto> findByIdUtente(Long idUtente);
	@Modifying
	@Query(value="INSERT INTO e_acquisti (id_carrello, prezzo, id_utente) VALUES(?1, ?2, ?3)", nativeQuery=true)
	void aggiungiAcquisto(Long idCarrello, Double prezzo, Long idUtente);
	@Modifying
	@Query(nativeQuery = true, value="DELETE  FROM e_acquisti WHERE id =?1")
	void cancellaAcquisti(Long id);
	
}
