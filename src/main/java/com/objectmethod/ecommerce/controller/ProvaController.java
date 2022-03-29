package com.objectmethod.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.objectmethod.ecommerce.ApiGiacenzeResponse;
import com.objectmethod.ecommerce.entity.Siu;
import com.objectmethod.ecommerce.entity.StoreProva;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/giacenze")
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
	@GetMapping("/store/{storeCode}")
		public ApiGiacenzeResponse store(@PathVariable("storeCode") String storeCode) {
		RestTemplate response = new RestTemplate();
		final String url= "http://192.168.1.192:8090/api/giacenze/store/" + storeCode;
		ApiGiacenzeResponse result =response.getForObject(url,ApiGiacenzeResponse.class);
	
		return result;
		}
	
	
	
	@PostMapping("/buy")
	public StoreProva buy(StoreProva body) {
		RestTemplate response = new RestTemplate();
		final String url ="http://192.168.1.192:8090/api/giacenze/buy";
		StoreProva result = response.postForObject(url, body, StoreProva.class);
		return result;
		
	}
	
	@GetMapping("/stores")
	public ResponseEntity<ApiGiacenzeResponse> stores(@RequestBody List<String> body) {
	RestTemplate response = new RestTemplate();
	HttpEntity<List<String>> request = new HttpEntity<>(body);
	final String url= "http://192.168.1.192:8090/api/giacenze/stores/" ;
	ResponseEntity<ApiGiacenzeResponse> result = response.exchange(url,HttpMethod.GET, request ,ApiGiacenzeResponse.class);
	return result;
	}
}



