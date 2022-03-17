package com.objectmethod.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.objectmethod.ecommerce.dto.CarrelloDto;
import com.objectmethod.ecommerce.entity.Carrello;


@Mapper(componentModel = "spring")
public abstract class CarrelloMapper {
	@Mapping(target= "idUtente", source ="utente.id")
	public abstract CarrelloDto toDto(Carrello entity);
	
	@Mapping(target= "utente.id", source ="idUtente")
	public abstract Carrello toModel(CarrelloDto dto);
}
	
	
	

