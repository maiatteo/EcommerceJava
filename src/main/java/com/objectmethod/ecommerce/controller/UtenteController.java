package com.objectmethod.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.objectmethod.ecommerce.dto.UtenteDto;
import com.objectmethod.ecommerce.service.UtenteService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/utenti")
public class UtenteController {
	
	@Autowired
	UtenteService utenteServ;
	
	@GetMapping("/all")
	public List<UtenteDto> getAll() {
		List<UtenteDto> dto = utenteServ.findAll();
		return dto;
	}
}
