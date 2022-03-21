package com.objectmethod.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.objectmethod.ecommerce.dto.AcquistoDto;
import com.objectmethod.ecommerce.entity.Acquisto;
import com.objectmethod.ecommerce.mapper.AcquistoMapper;
import com.objectmethod.ecommerce.repository.AcquistoRepository;

public class AcquistoService {

	@Autowired
	AcquistoRepository acquistoRepo;
	
	@Autowired
	AcquistoMapper acquistoMapper;
	
	public List<AcquistoDto> findAll(){
		List<Acquisto> lst = acquistoRepo.findAll();
		List<AcquistoDto> dto = acquistoMapper.toDto(lst);
		return dto;
	}
	
	public AcquistoDto findById(Long id) {
		Optional<Acquisto> acquisto = acquistoRepo.findById(id);
		if(acquisto.isPresent()) {
			AcquistoDto dto = acquistoMapper.toDto(acquisto.get());
			return dto;
		}
		else {
			return null;
		}
		
	}
	
}
