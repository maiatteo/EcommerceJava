package com.objectmethod.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.objectmethod.ecommerce.service.NegozioService;

@RestController
@RequestMapping("/api/negozio")
public class NegozioController {
	@Autowired 
	private NegozioService negoServ;
@GetMapping("/{id}")
	public ResponseEntity<?> getOne(Long id) {
		return negoServ.FindById(id);
	}
}
