package com.objectmethod.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.objectmethod.ecommerce.dto.NegozioDto;
import com.objectmethod.ecommerce.entity.Negozio;
import com.objectmethod.ecommerce.mapper.NegozioMapper;
import com.objectmethod.ecommerce.repository.NegozioRepository;

public class NegozioService {
	
	@Autowired
	NegozioMapper negozioMapper;
	
	@Autowired
	NegozioRepository negozioRepo;
	
	public List<NegozioDto> findAll(){
		List<Negozio> lst = negozioRepo.findAll();
		List<NegozioDto> dto = negozioMapper.toDto(lst);
		return dto;
	}

}
