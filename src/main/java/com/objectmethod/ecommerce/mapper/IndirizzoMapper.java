package com.objectmethod.ecommerce.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.objectmethod.ecommerce.dto.IndirizzoDto;
import com.objectmethod.ecommerce.dto.utils.UtenteConIndirizzoDto;
import com.objectmethod.ecommerce.entity.Indirizzo;


@Mapper(componentModel = "spring")
public abstract class  IndirizzoMapper {

	public abstract IndirizzoDto toDto(Indirizzo entity);
	
	
	public abstract Indirizzo toModel(IndirizzoDto dto);

	public abstract List<IndirizzoDto> toDto(List<Indirizzo> lst);
	
	
	public Indirizzo toModel(UtenteConIndirizzoDto dto) {
		if(dto==null) {
			return null;
		}
		Indirizzo ind=new Indirizzo();
		ind.setCitta(dto.getCitta());
		ind.setVia(dto.getVia());
		ind.setProvincia(dto.getProvincia());
		ind.setRegione(dto.getRegione());
		return ind;
	}
}
