package com.objectmethod.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objectmethod.ecommerce.dto.AcquistoDto;
import com.objectmethod.ecommerce.dto.CarrelloDto;
import com.objectmethod.ecommerce.dto.UtenteDto;
import com.objectmethod.ecommerce.entity.Acquisto;
import com.objectmethod.ecommerce.mapper.AcquistoMapper;
import com.objectmethod.ecommerce.mapper.CarrelloMapper;
import com.objectmethod.ecommerce.mapper.UtenteMapper;
import com.objectmethod.ecommerce.repository.AcquistoRepository;
import com.objectmethod.ecommerce.repository.CarrelloRepository;
import com.objectmethod.ecommerce.repository.UtenteRepository;

@Service
public class AcquistoService {
	@Autowired
	CarrelloMapper carrelloMapp;
	@Autowired
	CarrelloRepository carrelloRepo;
	@Autowired
	AcquistoRepository acquistoRepo;

	@Autowired
	UtenteRepository utenteRepo;

	@Autowired
	AcquistoMapper acquistoMapper;

	@Autowired
	UtenteMapper utenteMapper;

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

	public List<AcquistoDto> findByIdUtente(Long idUtente){
		List<Acquisto> lst = acquistoRepo.findByIdUtente(idUtente);
		List<AcquistoDto> dto = acquistoMapper.toDto(lst);
		return dto;

	}
	@Transactional
	public void aggiungiAcquisto(CarrelloDto dto) {
		acquistoRepo.aggiungiAcquisto(carrelloMapp.toModel(dto).getId(), carrelloMapp.toModel(dto).getPrezzo());
		carrelloRepo.creaCarrello(dto.getIdUtente());
		Long idCarrello = carrelloRepo.getLastCarrello(dto.getIdUtente());
		if(idCarrello != null) {
			UtenteDto uDto = utenteMapper.toDto(utenteRepo.getById(dto.getIdUtente()));
			if(uDto != null) {
				utenteRepo.setCarrello(idCarrello, uDto.getUsername());
			}
		}
	}
	@Transactional
	public void cancellaAcquisti(Long id) {
		acquistoRepo.cancellaAcquisti(id);
	}

}
