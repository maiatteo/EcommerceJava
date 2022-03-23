package com.objectmethod.ecommerce.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.objectmethod.ecommerce.dto.ProdottoDto;
import com.objectmethod.ecommerce.entity.Prodotto;

@Mapper(componentModel = "spring")
public abstract class ProdottoMapper {
	
	
	public abstract ProdottoDto toDto(Prodotto entity);
	
	public abstract Prodotto toModel(ProdottoDto dto);

	public abstract List<ProdottoDto> toDto(List<Prodotto> lst);
}
