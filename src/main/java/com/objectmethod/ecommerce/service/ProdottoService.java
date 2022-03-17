package com.objectmethod.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.objectmethod.ecommerce.dto.ProdottoDto;
import com.objectmethod.ecommerce.entity.Prodotto;
import com.objectmethod.ecommerce.repository.ProdottoRepository;

public class ProdottoService {

	@Autowired
	ProdottoRepository prodottoRepo;

	public List<ProdottoDto> findAll(){
		List<Prodotto> lst = prodottoRepo.findAll();
		List<ProdottoDto> dto = prodottoMapper.toDto(lst);
		return dto;
	}
}
