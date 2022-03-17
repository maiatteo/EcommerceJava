package com.objectmethod.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.objectmethod.ecommerce.dto.AcquistoDto;
import com.objectmethod.ecommerce.entity.Acquisto;
import com.objectmethod.ecommerce.repository.AcquistoRepository;

public class AcquistoService {

	@Autowired
	AcquistoRepository acquistoRepo;
	
	public List<AcquistoDto> findAll(){
		List<Acquisto> lst = acquistoRepo.findAll();
		List<AcquistoDto> dto = acquistoMapper.toDto(lst);
		return dto;
	}
	
}
