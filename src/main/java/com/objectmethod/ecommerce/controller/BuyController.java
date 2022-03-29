package com.objectmethod.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.objectmethod.ecommerce.ApiGiacenzeResponse;
import com.objectmethod.ecommerce.dto.utils.ApiBuyBody;
import com.objectmethod.ecommerce.dto.utils.StorePruductResponse;
import com.objectmethod.ecommerce.entity.StoreProva;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/buy")
public class BuyController {

	@PostMapping("/buy")
	public ApiGiacenzeResponse buy(@RequestBody List<ApiBuyBody> body) {
		RestTemplate response = new RestTemplate();
		final String url ="http://192.168.1.192:8090/api/giacenze/buy";
		 ApiGiacenzeResponse result = response.postForObject(url, body, ApiGiacenzeResponse.class);
		return result;}
	
	@GetMapping("/product/{productCode}")
	public ApiGiacenzeResponse product(@PathVariable("productCode") String productCode) {
	RestTemplate response = new RestTemplate();
	final String url= "http://192.168.1.192:8090/api/giacenze/product/" + productCode;
	ApiGiacenzeResponse result =response.getForObject(url,ApiGiacenzeResponse.class);
	return result;
	}
	
	@GetMapping("/store/{storeCode}/product/{productCode}")
	public StorePruductResponse storeProduct(@PathVariable("productCode") String productCode,@PathVariable("storeCode") String storeCode) {
	RestTemplate response = new RestTemplate();
	final String url= "http://192.168.1.192:8090/api/giacenze//store/"+storeCode+"/product/" + productCode;
	StorePruductResponse result =response.getForObject(url,StorePruductResponse.class);
	return result;
	}
	
}
