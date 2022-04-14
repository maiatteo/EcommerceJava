package com.objectmethod.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.objectmethod.ecommerce.dto.CarrelloDto;
import com.objectmethod.ecommerce.service.CarrelloService;
@RestController
@RequestMapping("/api/carrello")
public class CarrelloController {

	@Autowired  CarrelloService service;
	

}
