package com.objectmethod.ecommerce.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.objectmethod.ecommerce.dto.ProdottoDto;
import com.objectmethod.ecommerce.entity.Prodotto;

@Mapper(componentModel = "spring")
public abstract class ProdottoMapper {
	
	
	@Mapping(target= "idCarrello", source ="carrello.id")
	public abstract ProdottoDto toModel(Prodotto entity);
	
	@Mapping(target= "carrello.id", source ="idCarrello")
	public abstract Prodotto toModel(ProdottoDto dto);

	public abstract List<ProdottoDto> toDto(List<Prodotto> lst);
}
