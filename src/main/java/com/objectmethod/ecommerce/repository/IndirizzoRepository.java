package com.objectmethod.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objectmethod.ecommerce.entity.Indirizzo;

@Repository
public interface IndirizzoRepository extends JpaRepository<Indirizzo, Long>{

}
