package com.objectmethod.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.objectmethod.ecommerce.dto.AcquistoDto;
import com.objectmethod.ecommerce.service.AcquistoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/acquisto")
public class AcquistoController {
	
	@Autowired
	AcquistoService acquistoServ;

	@GetMapping("/all")
	public List<AcquistoDto> getAll(){
		return acquistoServ.findAll();
	}
}
