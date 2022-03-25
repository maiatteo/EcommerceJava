package com.objectmethod.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.objectmethod.ecommerce.dto.CarrelloDto;
import com.objectmethod.ecommerce.dto.ProdottoDto;
import com.objectmethod.ecommerce.service.ProdottoService;
import com.objectmethod.ecommerce.utils.ResponseWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/prodotto")
public class ProductController {

	@Autowired 
	ProdottoService service;
	
	@GetMapping("/all")
	public List<ProdottoDto> getAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseWrapper<ProdottoDto>  getOne(@PathVariable Long id) {
		return service.getOne(id);
	}
	
	@PutMapping("/registrati")
	public ResponseWrapper<ProdottoDto> creazione(@RequestBody ProdottoDto body) {
		return service.creazione(body);
	}
	@DeleteMapping("/{id}")
	public String  delete(@PathVariable Long id) {
		return service.delect(id);
	}
	
	
	//EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE IL CONTROLLO
	@PostMapping("/aggiungi/{id}")
	public String aggiungiAlCarrello(@PathVariable Long id, @RequestBody CarrelloDto carrello, @RequestParam Integer quantita) {
		service.aggiungiAlCarrello(id, carrello, quantita);
		return "Bella";
	}
	
}
