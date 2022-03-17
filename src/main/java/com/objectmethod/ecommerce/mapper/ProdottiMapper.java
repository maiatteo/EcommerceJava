package com.objectmethod.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.objectmethod.ecommerce.dto.ProdottoDto;
import com.objectmethod.ecommerce.entity.Prodotto;

@Mapper(componentModel = "spring")
public abstract class ProdottiMapper {
	
	
	@Mapping(target= "idCarrello", source ="carrello.id")
	public abstract ProdottoDto toModel(Prodotto entity);
	
	@Mapping(target= "carrello.id", source ="idCarrello")
	public abstract Prodotto toModel(ProdottoDto dto);
}
