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
import org.springframework.web.bind.annotation.RestController;

import com.objectmethod.ecommerce.dto.ProdottoDto;
import com.objectmethod.ecommerce.dto.UtenteDto;
import com.objectmethod.ecommerce.dto.utils.UtenteConIndirizzoDto;
import com.objectmethod.ecommerce.dto.utils.UtenteTokenDto;
import com.objectmethod.ecommerce.service.CarrelloService;
import com.objectmethod.ecommerce.service.UtenteService;
import com.objectmethod.ecommerce.utils.ResponseWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/utenti")
public class UtenteController {

	@Autowired
	UtenteService utenteServ;
	
	@Autowired
	CarrelloService carrelloService;

	@GetMapping("/all")
	public List<UtenteDto> getAll() {
		return utenteServ.findAll();
	}
	@PutMapping("/registrati")
	public ResponseWrapper<UtenteDto> registrati(@RequestBody UtenteConIndirizzoDto body) {
		log.debug("sium",body);
		return utenteServ.registrazione(body);
	}
	
	@PostMapping("/login")
	public ResponseWrapper<UtenteTokenDto> login(@RequestBody UtenteDto utente){
		return utenteServ.login(utente);
	}
	
	@GetMapping("/{id}")
	public ResponseWrapper<UtenteDto> getOne(@PathVariable Long id) {
		return utenteServ.getOne(id);
	}
	@DeleteMapping("/{id}")
	public String  delete(@PathVariable Long id) {
		return utenteServ.delect(id);
	}
	
	@PostMapping("carrello")
	public void carrello(@RequestBody UtenteDto dto) {
		carrelloService.creaCarrello(dto);
	}
	
}