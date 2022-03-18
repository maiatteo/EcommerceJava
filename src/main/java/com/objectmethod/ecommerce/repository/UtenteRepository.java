package com.objectmethod.ecommerce.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.objectmethod.ecommerce.entity.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long>{
	
	@Transactional
	@Modifying
	@Query(value = "insert into utenti(nome,cognome,email,username,password,amministratore) values (?1,?2,?3,?4,md5(?5),false)",nativeQuery=true)
	public Utente registrati(String n,String c, String e,String u,String p);
	
	@Query(value = "select * from utenti where email = :email and password = :password",nativeQuery=true)
	public Optional<Utente>  Login(String email ,String password);
}
