package com.objectmethod.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objectmethod.ecommerce.dto.CarrelloDto;
import com.objectmethod.ecommerce.dto.IndirizzoDto;
import com.objectmethod.ecommerce.dto.UtenteDto;
import com.objectmethod.ecommerce.dto.utils.UtenteConIndirizzoDto;
import com.objectmethod.ecommerce.dto.utils.UtenteTokenDto;
import com.objectmethod.ecommerce.entity.Utente;
import com.objectmethod.ecommerce.mapper.CarrelloMapper;
import com.objectmethod.ecommerce.mapper.UtenteMapper;
import com.objectmethod.ecommerce.repository.UtenteRepository;
import com.objectmethod.ecommerce.service.jwt.JWTService;
import com.objectmethod.ecommerce.utils.ResponseWrapper;

@Service
public class UtenteService {

	@Autowired
	CarrelloService carrello;
	
	@Autowired
	IndirizzoService indirizzo;

	@Autowired
	UtenteMapper utenteMapper;

	@Autowired
	CarrelloMapper carrelloMapper;
	
	@Autowired
	UtenteRepository utenteRepo;
	@Autowired
	JWTService jwt;

	public List<UtenteDto> findAll(){
		List<Utente> lst = utenteRepo.findAll();
		List<UtenteDto> dto = utenteMapper.toDto(lst);
		return dto;
	}

	public ResponseWrapper<UtenteDto> registrazione(UtenteConIndirizzoDto utente){
		ResponseWrapper<UtenteDto> resp= new ResponseWrapper<>();
		List<String> error=new ArrayList<String>();
		if(utente ==null) {
			error.add("utente nullo");
			resp.setError(error);
			return resp;
		}
		Utente entity = utenteMapper.toModel(utente);
		if(entity.getNome()==null ||
				entity.getCognome()==null||
				entity.getEmail()==null||
				entity.getUsername()==null||
				entity.getPassword()==null) {
			error.add("campo mancante");
			resp.setError(error);
			return resp;
		}
		if(utenteRepo.getByEmail(entity.getEmail()).isPresent()||
				utenteRepo.getByUsername(entity.getUsername()).isPresent()) {
			error.add("username o email gia esistenti");
			resp.setError(error);
			return resp;
		}
		ResponseWrapper<IndirizzoDto> creazione=indirizzo.crea(utente);
		if(creazione.getBody()==null) {
			resp.setError(creazione.getError());
			return resp;
		}
		utenteRepo.registrati(entity.getNome(), entity.getCognome(),
				entity.getEmail(), entity.getUsername(), entity.getPassword(),creazione.getBody().getId());
		entity=utenteRepo.getByUsername(entity.getUsername()).get();
		CarrelloDto dtoCarrello = carrello.creaCarrello(utenteMapper.toDto(entity));
		entity.setCarrello(carrelloMapper.toModel(dtoCarrello));
		resp.setBody(utenteMapper.toDto(entity));
		resp.setError(error);
		return resp;
	}
	public ResponseWrapper<UtenteTokenDto> login(UtenteDto utente){
		ResponseWrapper<UtenteTokenDto> resp= new ResponseWrapper<>();
		List<String> error=new ArrayList<String>();
		Optional<Utente> user= utenteRepo.Login(utente.getEmail(), utente.getPassword());
		if(!user.isPresent()) {
			error.add("email o password errate");
			resp.setError(error);
			return resp;
		}
		String token = jwt.createJWTToken(utenteMapper.toDto(user.get()));
		resp.setBody(utenteMapper.toDto(user.get(),token));
		resp.setError(error);
		return resp;
	}

	public ResponseWrapper<UtenteDto> getOne(Long id){
		ResponseWrapper<UtenteDto> resp=new ResponseWrapper<>() ;
		List<String> error= new ArrayList<String>();
		if(id==null) {
			error.add("id non presente");
			resp.setError(error);
		}
		Utente entity =utenteRepo.getById(id);
		if(entity==null) {
			error.add("utente non presente");
			resp.setError(error);
		}
		resp.setBody(utenteMapper.toDto(entity));
		resp.setError(error);
		return resp;
	}
	public String delect(Long id) {
		if(id==null) {
			return "id nullo";
		}
		utenteRepo.deleteById(id);
		return "cancellazione avvenuta";
	}
}
