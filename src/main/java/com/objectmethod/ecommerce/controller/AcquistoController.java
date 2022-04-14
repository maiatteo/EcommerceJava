package com.objectmethod.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.objectmethod.ecommerce.dto.AcquistoDto;
import com.objectmethod.ecommerce.dto.CarrelloDto;
import com.objectmethod.ecommerce.service.AcquistoService;
import com.objectmethod.ecommerce.service.jwt.JWTService;
import com.objectmethod.ecommerce.utils.ResponseWrapper;

import lombok.extern.slf4j.Slf4j;
@CrossOrigin(origins="*")
@RestController
@Slf4j
@RequestMapping("/api/acquisto")
public class AcquistoController {
	
	@Autowired
	JWTService jwtServ;
	
	@Autowired
	AcquistoService acquistoServ;

	@GetMapping("/all")
	public List<AcquistoDto> getAll(){
		return acquistoServ.findAll();
	}
	@PostMapping("/acquista")
	public ResponseEntity<?> aggiungiAcquisti(@RequestBody CarrelloDto dto) {
		acquistoServ.aggiungiAcquisto(dto);
		return ResponseEntity.ok(new ResponseWrapper<String>("Ordine effettuato"));
	}
	@PostMapping("/cancella/{id}")
	public void cancellaAcquisti(@PathVariable("id") Long id) {
		acquistoServ.cancellaAcquisti(id);
		
		
	}
}
