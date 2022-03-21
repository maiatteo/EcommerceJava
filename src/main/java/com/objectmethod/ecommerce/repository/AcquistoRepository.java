package com.objectmethod.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.objectmethod.ecommerce.entity.Acquisto;

@Repository
public interface AcquistoRepository  extends JpaRepository<Acquisto, Long>{

	@Query(value="SELECT * FROM e_acquisti WHERE id_utente = ?1", nativeQuery = true)
	List<Acquisto> findByIdUtente(Long idUtente);
	
}
