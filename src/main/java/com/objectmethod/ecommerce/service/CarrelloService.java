package com.objectmethod.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.objectmethod.ecommerce.dto.CarrelloDto;
import com.objectmethod.ecommerce.dto.UtenteDto;
import com.objectmethod.ecommerce.entity.Carrello;
import com.objectmethod.ecommerce.mapper.CarrelloMapper;
import com.objectmethod.ecommerce.mapper.UtenteMapper;
import com.objectmethod.ecommerce.repository.CarrelloRepository;
import com.objectmethod.ecommerce.repository.UtenteRepository;
@Service
public class CarrelloService {
	
	@Autowired
	UtenteRepository utenteRepo;
	
	@Autowired
	UtenteMapper utenteMapper;
	
	@Autowired
	CarrelloMapper carrelloMapper;
	
	@Autowired
	CarrelloRepository carrelloRepo;
	
	public CarrelloDto findByIdUtente(Long idUtente) {
		Optional<Carrello> carrello = carrelloRepo.findById(idUtente);
		if(carrello.isPresent()) {
			return carrelloMapper.toDto(carrello.get());
		}
		return null;
	}
	public List<CarrelloDto> findAll(){
		List<Carrello> lst = carrelloRepo.findAll();
		List<CarrelloDto> dto = carrelloMapper.toDto(lst);
		return dto;
	}
	
	@Transactional
	public CarrelloDto creaCarrello(UtenteDto uDto) {
		//Carrello carrello = new Carrello();
		//carrello.setUtente(utenteMapper.toModel(uDto));
		carrelloRepo.creaCarrello(uDto.getId());
		Long idUtente = carrelloRepo.getLastCarrello(uDto.getId());
		utenteRepo.setCarrello(idUtente, uDto.getUsername());
		return findByIdUtente(uDto.getId());
	}

}
