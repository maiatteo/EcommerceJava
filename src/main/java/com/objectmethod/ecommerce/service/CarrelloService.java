package com.objectmethod.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.objectmethod.ecommerce.dto.AcquistoDto;
import com.objectmethod.ecommerce.dto.CarrelloDto;
import com.objectmethod.ecommerce.dto.ProdottiCarrelloDto;
import com.objectmethod.ecommerce.dto.UtenteDto;
import com.objectmethod.ecommerce.entity.Carrello;
import com.objectmethod.ecommerce.mapper.CarrelloMapper;
import com.objectmethod.ecommerce.mapper.ProdottiCarrelloMapper;
import com.objectmethod.ecommerce.mapper.UtenteMapper;
import com.objectmethod.ecommerce.repository.CarrelloRepository;
import com.objectmethod.ecommerce.repository.ProdottiCarrelloRepository;
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
	ProdottiCarrelloMapper mapper;
	
	@Autowired
	CarrelloRepository carrelloRepo;
	
	@Autowired
	ProdottiCarrelloRepository prodCarrelloRepo;
	
	public CarrelloDto findById(Long id) {
		Optional<Carrello> carrello = carrelloRepo.findById(id);
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
		Long idCarrello = carrelloRepo.getLastCarrello(uDto.getId());
		utenteRepo.setCarrello(idCarrello, uDto.getUsername());
		return findById(idCarrello);
	}
	
	public Long getLastCarrello(Long idUtente) {
		return carrelloRepo.getLastCarrello(idUtente);
	}
	public List<ProdottiCarrelloDto> prodottiDaAcquistare(Long idCarrello){
		return mapper.toDto(prodCarrelloRepo.getProdottiCarrello(idCarrello));
	}


}
