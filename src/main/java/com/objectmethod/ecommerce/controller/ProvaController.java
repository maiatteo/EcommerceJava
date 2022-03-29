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

import com.objectmethod.ecommerce.dto.utils.ApiBuyBody;
import com.objectmethod.ecommerce.dto.utils.ApiGiacenzeResponse;
import com.objectmethod.ecommerce.dto.utils.ProductsResponse;
import com.objectmethod.ecommerce.dto.utils.StorePruductResponse;
import com.objectmethod.ecommerce.dto.utils.StoresResponse;
import com.objectmethod.ecommerce.entity.Siu;
import com.objectmethod.ecommerce.entity.StoreProva;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/giacenze")
public class ProvaController {

	final String urlBase = "http://192.168.1.192:8090/api/giacenze";
	
	@GetMapping("/store/{storeCode}")
		public ApiGiacenzeResponse store(@PathVariable("storeCode") String storeCode) {
		RestTemplate response = new RestTemplate();
		final String url= urlBase + "/store/" + storeCode;
		ApiGiacenzeResponse result =response.getForObject(url,ApiGiacenzeResponse.class);
	
		return result;
		}
	
	
	
	@PostMapping("/buy")
	public ApiGiacenzeResponse buy(@RequestBody List<ApiBuyBody> body) {
		RestTemplate response = new RestTemplate();
		final String url = urlBase + "/buy";
		ApiGiacenzeResponse result = response.postForObject(url, body, ApiGiacenzeResponse.class);
		return result;}
	
	@GetMapping("/product/{productCode}")
	public ApiGiacenzeResponse product(@PathVariable("productCode") String productCode) {
	RestTemplate response = new RestTemplate();
	final String url = urlBase + "/product/" + productCode;
	ApiGiacenzeResponse result =response.getForObject(url,ApiGiacenzeResponse.class);
	return result;
	}
	
	@GetMapping("/stores/{storeCode}/product/{productCode}")
	public StorePruductResponse storeProduct(@PathVariable("productCode") String productCode,@PathVariable("storeCode") String storeCode) {
	RestTemplate response = new RestTemplate();
	final String url= urlBase + "/store/" + storeCode + "/product/" + productCode;
	StorePruductResponse result =response.getForObject(url,StorePruductResponse.class);
	return result;
	}
	
	@PostMapping("/stores")
	public StoresResponse stores(@RequestBody List<String> body) {
		RestTemplate response = new RestTemplate();
		final String url= urlBase + "/stores" ;
		StoresResponse result = response.postForObject(url, body, StoresResponse.class);
		return result;
	}
	
	@PostMapping("/products")
	public ProductsResponse products(@RequestBody List<String> body) {
		RestTemplate response = new RestTemplate();
		final String url= urlBase + "/products" ;
		ProductsResponse result = response.postForObject(url, body, ProductsResponse.class);
		return result;
	}
}

	


