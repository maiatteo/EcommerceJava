package com.objectmethod.ecommerce.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.objectmethod.ecommerce.dto.UtenteDto;
import com.objectmethod.ecommerce.entity.Utente;

@Mapper(componentModel = "spring")
public abstract class UtenteMapper {
	@Mapping(target= "idCarrello", source ="carrello.id")
	@Mapping(target= "idIndirizzo", source ="indirizzoUte.id")
	public abstract UtenteDto toDto(Utente entity);
	
	@Mapping(target= "carrello.id", source ="idCarrello")
	@Mapping(target= "indirizzoUte.id", source ="idIndirizzo")
	public abstract Utente toModel(UtenteDto dto);

	public abstract List<UtenteDto> toDto(List<Utente> lst);
}
