package com.objectmethod.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.objectmethod.ecommerce.dto.CarrelloDto;
import com.objectmethod.ecommerce.entity.Carrello;
import com.objectmethod.ecommerce.mapper.CarrelloMapper;
import com.objectmethod.ecommerce.repository.CarrelloRepository;

public class CarrelloService {
	
	@Autowired
	CarrelloRepository carrelloRepo;
	
	@Autowired
	CarrelloMapper carrelloMapper;
	
	public List<CarrelloDto> findAll(){
		List<Carrello> lst = carrelloRepo.findAll();
		List<CarrelloDto> dto = carrelloMapper.toDto(lst);
		return dto;
	}

}
