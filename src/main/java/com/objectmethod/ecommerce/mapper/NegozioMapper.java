package com.objectmethod.ecommerce.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.objectmethod.ecommerce.dto.NegozioDto;
import com.objectmethod.ecommerce.entity.Negozio;

@Mapper(componentModel = "spring")
public abstract class NegozioMapper {
	@Mapping(target= "idIndirizzo", source ="indirizzoNeg.id")
	public abstract NegozioDto toDto(Negozio entity);
	
	@Mapping(target= "indirizzoNeg.id", source ="idIndirizzo")
	public abstract Negozio toModel(NegozioDto dto);

	@Mapping(target= "indirizzoNeg.id", source ="idIndirizzo")
	public abstract List<NegozioDto> toDto(List<Negozio> lst);
}
