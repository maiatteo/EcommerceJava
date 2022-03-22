package com.objectmethod.ecommerce.mapper;

import java.util.List;

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

	@Mapping(target= "idUtente", source ="utente.id")
	public abstract List<CarrelloDto> toDto(List<Carrello> lst) ;
}
	
	
	

