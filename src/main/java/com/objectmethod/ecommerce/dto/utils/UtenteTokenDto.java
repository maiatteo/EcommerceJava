package com.objectmethod.ecommerce.dto.utils;


import com.objectmethod.ecommerce.dto.UtenteDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UtenteTokenDto extends UtenteDto{
	private String token;
}
