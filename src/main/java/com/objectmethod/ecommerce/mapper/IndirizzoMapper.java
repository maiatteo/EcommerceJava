package com.objectmethod.ecommerce.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.objectmethod.ecommerce.dto.IndirizzoDto;
import com.objectmethod.ecommerce.entity.Indirizzo;


@Mapper
public abstract class  IndirizzoMapper {

	public abstract IndirizzoDto toDto(Indirizzo entity);
	
	
	public abstract Indirizzo toModel(IndirizzoDto dto);


	public abstract List<IndirizzoDto> toDto(List<Indirizzo> lst);
}
