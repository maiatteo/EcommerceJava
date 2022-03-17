package com.objectmethod.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objectmethod.ecommerce.dto.UtenteDto;
import com.objectmethod.ecommerce.entity.Utente;
import com.objectmethod.ecommerce.repository.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
	UtenteRepository utenteRepo;

	public List<UtenteDto> findAll(){
		List<Utente> lst = utenteRepo.findAll();
		List<UtenteDto> dto = utenteMapper.toDto(lst);
		return dto;
	}
	
}
