package com.objectmethod.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objectmethod.ecommerce.dto.IndirizzoDto;
import com.objectmethod.ecommerce.dto.UtenteDto;
import com.objectmethod.ecommerce.dto.utils.UtenteConIndirizzoDto;
import com.objectmethod.ecommerce.dto.utils.UtenteTokenDto;
import com.objectmethod.ecommerce.entity.Utente;
import com.objectmethod.ecommerce.mapper.UtenteMapper;
import com.objectmethod.ecommerce.repository.UtenteRepository;
import com.objectmethod.ecommerce.service.jwt.JWTService;
import com.objectmethod.ecommerce.utils.ResponseWrapper;

@Service
public class UtenteService {

	@Autowired
	IndirizzoService indirizzo;
	
	@Autowired
	UtenteMapper utenteMapper;

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
			if(utente !=null) {
			Utente entity = utenteMapper.toModel(utente);
			if(entity.getNome()!=null ||
					entity.getCognome()!=null||
					entity.getEmail()!=null||
					entity.getUsername()!=null||
					entity.getPassword()!=null) {
				if(!utenteRepo.getByEmail(entity.getEmail()).isPresent()&&
						!utenteRepo.getByUsername(entity.getUsername()).isPresent()) {
					ResponseWrapper<IndirizzoDto> creazione=indirizzo.crea(utente);
					List<String> e=creazione.getError();if(creazione.getBody()==null) {
						resp.setError(e);
						return resp;
					}
				utenteRepo.registrati(entity.getNome(), entity.getCognome(),
						entity.getEmail(), entity.getUsername(), entity.getPassword(),creazione.getBody().getId());
				resp.setBody(utenteMapper.toDto(utenteRepo.getByUsername(entity.getUsername()).get()));
				}else {
					error.add("username o email gia esistenti");
				}
			}else {
				error.add("campo mancante");
			}
		}else {
			error.add("utente nullo");
		}
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

}
