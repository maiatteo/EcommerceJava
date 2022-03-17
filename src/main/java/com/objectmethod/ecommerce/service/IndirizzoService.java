package com.objectmethod.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.objectmethod.ecommerce.dto.IndirizzoDto;
import com.objectmethod.ecommerce.entity.Indirizzo;
import com.objectmethod.ecommerce.repository.IndirizzoRepository;

public class IndirizzoService {
	
	@Autowired
	IndirizzoRepository indirizzoRepo;
	
	public List<IndirizzoDto> findAll(){
		List<Indirizzo> lst = indirizzoRepo.findAll();
		List<IndirizzoDto> dto = utenteMapper.toDto(lst);
		return dto;
	}

}
