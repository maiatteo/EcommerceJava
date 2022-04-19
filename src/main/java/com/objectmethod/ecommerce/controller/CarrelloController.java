package com.objectmethod.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.objectmethod.ecommerce.dto.AcquistoDto;
import com.objectmethod.ecommerce.dto.CarrelloDto;
import com.objectmethod.ecommerce.dto.ProdottiCarrelloDto;
import com.objectmethod.ecommerce.mapper.CarrelloMapper;
import com.objectmethod.ecommerce.service.CarrelloService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/carrello")
public class CarrelloController {

	@Autowired  CarrelloService service;
	@Autowired CarrelloMapper mapper;
	
	@GetMapping("/{idUtente}")
	public Long getLastCarrello(@PathVariable("idUtente") Long idUtente) {
		return service.getLastCarrello(idUtente);
	}
	@GetMapping("/all/{idCarrello}")
	public List<ProdottiCarrelloDto> getProdottiDaAcquistare(@PathVariable("idCarrello")Long idCarrello){
		return service.prodottiDaAcquistare(idCarrello);
	}
	

}
