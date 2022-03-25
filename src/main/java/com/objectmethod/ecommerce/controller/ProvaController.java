package com.objectmethod.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.objectmethod.ecommerce.entity.Siu;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/prova")
public class ProvaController {



	@GetMapping("/e")
	public Siu prova() {
		RestTemplate response = new RestTemplate();

		final String uri = "http://jsonplaceholder.typicode.com/posts/9";

		Siu result = response.getForObject(uri, Siu.class);
		return result;

	}

	//	@Autowired
	//	private WebClientCustomizer.Builder webClientBuilder;
	//
	//	@GetMapping("/e")
	//	public Object getPost() {		
	//	}


}
