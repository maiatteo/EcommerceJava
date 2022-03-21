package com.objectmethod.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.objectmethod.ecommerce.dto.CarrelloDto;
import com.objectmethod.ecommerce.entity.Carrello;
import com.objectmethod.ecommerce.mapper.CarrelloMapper;
import com.objectmethod.ecommerce.repository.CarrelloRepository;
@Service
public class CarrelloService {
	
	@Autowired
	CarrelloMapper carrelloMapper;
	
	@Autowired
	CarrelloRepository carrelloRepo;
	
	
	public List<CarrelloDto> findAll(){
		List<Carrello> lst = carrelloRepo.findAll();
		List<CarrelloDto> dto = carrelloMapper.toDto(lst);
		return dto;
	}
	
	public Carrello aggiungiAlCarrello(CarrelloDto dto) {
		CarrelloDto prodottoCarrello = new CarrelloDto();
		prodottoCarrello.setId(dto.getId());
		if (prodottoCarrello.getId() != null){
			prodottoCarrello.setIdProdotti(dto.getIdProdotti());
			prodottoCarrello.setQuantita(dto.getQuantita());
			return carrelloMapper.toModel(prodottoCarrello);
		}
		return (Carrello) ResponseEntity.badRequest();
	}

}
