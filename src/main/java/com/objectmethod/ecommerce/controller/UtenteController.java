package com.objectmethod.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.objectmethod.ecommerce.dto.UtenteDto;
import com.objectmethod.ecommerce.dto.utils.UtenteTokenDto;
import com.objectmethod.ecommerce.service.UtenteService;
import com.objectmethod.ecommerce.utils.ResponseWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/utenti")
public class UtenteController {

	@Autowired
	UtenteService utenteServ;

	@GetMapping("/all")
	public List<UtenteDto> getAll() {
		return utenteServ.findAll();
	}
	@PutMapping("/registrati")
	public ResponseWrapper<UtenteDto> registrati(@RequestBody UtenteDto utente) {
		return utenteServ.registrazione(utente);
	}
	
	@PostMapping("/login")
	public ResponseWrapper<UtenteTokenDto> login(@RequestBody UtenteDto utente){
		return utenteServ.login(utente);
	}
	
}