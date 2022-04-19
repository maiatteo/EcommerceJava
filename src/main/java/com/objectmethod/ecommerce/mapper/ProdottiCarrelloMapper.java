package com.objectmethod.ecommerce.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.objectmethod.ecommerce.dto.ProdottiCarrelloDto;
import com.objectmethod.ecommerce.entity.ProdottiCarrello;


@Mapper(componentModel = "spring")
public abstract class ProdottiCarrelloMapper {

public abstract ProdottiCarrelloDto toDto(ProdottiCarrello entity);
	
	public abstract ProdottiCarrello toModel(ProdottiCarrelloDto dto);

	public abstract List<ProdottiCarrelloDto> toDto(List<ProdottiCarrello> lst);
	
	public abstract List<ProdottiCarrello> toModel(List<ProdottiCarrelloDto> dto);
}

