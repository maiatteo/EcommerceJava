package com.objectmethod.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objectmethod.ecommerce.entity.Negozio;

@Repository
public interface NegozioRepository extends JpaRepository<Negozio, Long>{

}
