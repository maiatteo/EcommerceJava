package com.objectmethod.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.objectmethod.ecommerce.dto.AcquistoDto;
import com.objectmethod.ecommerce.entity.Acquisto;
@Mapper(componentModel = "spring")
public abstract class AcquistoMapper {
	@Mapping(target= "idCarrello", source ="carrello.id")
	@Mapping(target= "idUtente", source ="utente.id")
	public abstract AcquistoDto toDto(Acquisto entity);
	
	@Mapping(target= "carrello.id", source ="idCarrello")
	@Mapping(target= "utente.id", source ="idUtente")
	public abstract Acquisto toModel(AcquistoDto dto);
	
}
