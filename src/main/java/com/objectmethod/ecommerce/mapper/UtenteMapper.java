package com.objectmethod.ecommerce.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.objectmethod.ecommerce.dto.UtenteDto;
import com.objectmethod.ecommerce.dto.utils.UtenteTokenDto;
import com.objectmethod.ecommerce.entity.Utente;

@Mapper(componentModel = "spring")
public abstract class UtenteMapper {
	
	@Mapping(target = "password", ignore = true)
	@Mapping(target= "idCarrello", source ="carrello.id")
	@Mapping(target= "idIndirizzo", source ="indirizzoUte.id")
	public abstract UtenteDto toDto(Utente entity);
	
	
	@Mapping(target= "carrello.id", source ="idCarrello")
	@Mapping(target= "indirizzoUte.id", source ="idIndirizzo")
	public abstract Utente toModel(UtenteDto dto);

	
	@Mapping(target = "password", ignore = true)
	public abstract List<UtenteDto> toDto(List<Utente> lst);
	
	@Mapping(target = "password", ignore = true)
	@Mapping(target= "idCarrello", source ="entity.carrello.id")
	@Mapping(target= "idIndirizzo", source ="entity.indirizzoUte.id")
	public abstract UtenteTokenDto toDto(Utente entity,String token);
}
