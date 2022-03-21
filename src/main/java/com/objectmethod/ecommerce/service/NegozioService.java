package com.objectmethod.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.objectmethod.ecommerce.dto.NegozioDto;
import com.objectmethod.ecommerce.entity.Negozio;
import com.objectmethod.ecommerce.mapper.NegozioMapper;
import com.objectmethod.ecommerce.repository.NegozioRepository;
import com.objectmethod.ecommerce.utils.ResponseWrapper;

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
	public ResponseEntity<?> FindByCodice(Long codice) {
		
		NegozioDto negozioConCodice = negozioMapper.toDto(negozioRepo.findById(codice).get());
		if(negozioConCodice == null) {
			return (ResponseEntity<?>) ResponseEntity.badRequest();
		}else {
								}
		return ResponseEntity.ok(new ResponseWrapper<NegozioDto>(negozioConCodice));
		}
	public ResponseEntity<?> FindById(Long id) {
		
		NegozioDto negozioConId = negozioMapper.toDto(negozioRepo.findById(id).get());
		if(negozioConId == null) {
			return (ResponseEntity<?>) ResponseEntity.badRequest();
		}else {
								}
		return ResponseEntity.ok(new ResponseWrapper<NegozioDto>(negozioConId));
		}

		
		
	}


