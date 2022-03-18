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
	@Query(value = "insert into e_utenti(nome,cognome,email,username,password,amministratore,id_indirizzo) values (?1,?2,?3,?4,md5(?5),false,?6)",nativeQuery=true)
	public void registrati(String n,String c, String e,String u,String p,Long i);
	
	@Query(value = "select * from e_utenti where email = :email and password = md5(:password)",nativeQuery=true)
	public Optional<Utente>  Login(String email ,String password);
	
	@Query(value ="select * from e_utenti where username = :username",nativeQuery=true)
	public Optional<Utente> getByUsername(String username);
	
	@Query(value ="select * from e_utenti where email = :email",nativeQuery=true)
	public Optional<Utente> getByEmail(String email);
}
