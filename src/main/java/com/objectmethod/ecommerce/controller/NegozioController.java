package com.objectmethod.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.objectmethod.ecommerce.dto.NegozioDto;
import com.objectmethod.ecommerce.service.NegozioService;


@RestController
@RequestMapping("/api/negozio")
public class NegozioController {
	@Autowired 
	private NegozioService negoServ;
@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") Long id) {
		return negoServ.FindById(id);
	}
@GetMapping("/negozi")
public List<NegozioDto> getAll(){
	return negoServ.findAll();
}
}
