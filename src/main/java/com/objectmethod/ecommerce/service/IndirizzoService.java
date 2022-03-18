package com.objectmethod.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objectmethod.ecommerce.dto.IndirizzoDto;
import com.objectmethod.ecommerce.dto.utils.UtenteConIndirizzoDto;
import com.objectmethod.ecommerce.entity.Indirizzo;
import com.objectmethod.ecommerce.mapper.IndirizzoMapper;
import com.objectmethod.ecommerce.repository.IndirizzoRepository;
import com.objectmethod.ecommerce.utils.ResponseWrapper;

@Service
public class IndirizzoService {
	
	@Autowired
	IndirizzoMapper indirizzoMapper;
	
	@Autowired
	IndirizzoRepository indirizzoRepo;
	
	public List<IndirizzoDto> findAll(){
		List<Indirizzo> lst = indirizzoRepo.findAll();
		List<IndirizzoDto> dto = indirizzoMapper.toDto(lst);
		return dto;
	}
	
	public ResponseWrapper<IndirizzoDto> crea(UtenteConIndirizzoDto dto){
		ResponseWrapper<IndirizzoDto> resp= new ResponseWrapper<IndirizzoDto>();
		List<String> error=new ArrayList<String>();
		if(dto==null) {
			error.add("compilare campi del indirizzo");
			resp.setError(error);
			return resp;
		}
		if(dto.getCitta()==null||dto.getVia()==null||dto.getProvincia()==null||dto.getRegione()==null) {
			error.add("compilare tutti campi del indirizzo");
			resp.setError(error);
			return resp;
		}
		resp.setBody(indirizzoMapper.toDto(indirizzoRepo.save(indirizzoMapper.toModel(dto)))); 
		resp.setError(error);
		return resp;
	}
}
