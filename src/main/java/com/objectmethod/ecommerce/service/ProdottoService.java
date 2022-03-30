package com.objectmethod.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objectmethod.ecommerce.dto.CarrelloDto;
import com.objectmethod.ecommerce.dto.ProdottoDto;
import com.objectmethod.ecommerce.entity.Prodotto;
import com.objectmethod.ecommerce.mapper.CarrelloMapper;
import com.objectmethod.ecommerce.mapper.ProdottoMapper;
import com.objectmethod.ecommerce.repository.ProdottoRepository;
import com.objectmethod.ecommerce.utils.ResponseWrapper;
@Service
public class ProdottoService {
	
	@Autowired
	ProdottoMapper prodottoMapper;

	@Autowired
	CarrelloMapper carrelloMapper;
	
	@Autowired
	ProdottoRepository prodottoRepo;

	public List<ProdottoDto> findAll(){
		List<Prodotto> lst = prodottoRepo.findAll();
		List<ProdottoDto> dto = prodottoMapper.toDto(lst);
		return dto;
	}
	
	public ResponseWrapper<ProdottoDto> getOne(Long id){
		ResponseWrapper<ProdottoDto> resp=new ResponseWrapper<>() ;
		List<String> error= new ArrayList<String>();
		if(id==null) {
			error.add("id non presente");
			resp.setError(error);
		}
		Prodotto entity =prodottoRepo.getById(id);
		if(entity==null) {
			error.add("prodotto non presente");
			resp.setError(error);
		}
		resp.setBody(prodottoMapper.toDto(entity));
		resp.setError(error);
		return resp;
	}
	
	public ResponseWrapper<ProdottoDto> creazione(ProdottoDto prod){
		ResponseWrapper<ProdottoDto> resp=new ResponseWrapper<>() ;
		List<String> error= new ArrayList<String>();
		if(prod==null) {
			error.add("il prodotto è null");
			resp.setError(error);
		}
		if(prod.getCodice()==null||
				prod.getNome()==null||
				prod.getPeso()==null||
				prod.getPrezzo()==null) {
			error.add("compilare tutti i campi");
			resp.setError(error);
		}
		resp.setBody(prodottoMapper.toDto(prodottoRepo.save(prodottoMapper.toModel(prod))));
		resp.setError(error);
		return resp;
	}
	
	public String delect(Long id) {
		if(id==null) {
			return "id nullo";
		}
		 prodottoRepo.deleteById(id);
		return "cancellazione avvenuta";
	}
	
	
	//AGGIUNGI TOKEN
	@Transactional
	public void aggiungiAlCarrello(Long idProdotto, CarrelloDto carrello, Integer quantita) {
		prodottoRepo.aggiungiAlCarrello(idProdotto, carrelloMapper.toModel(carrello).getId() , quantita);
	}
	public List<ProdottoDto> findByName(String name){
		List<Prodotto> prodotti = prodottoRepo.findByNsme(name);
		return prodottoMapper.toDto(prodotti);
		
	}
	
}
