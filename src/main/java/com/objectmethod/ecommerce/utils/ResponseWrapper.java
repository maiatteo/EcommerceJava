package com.objectmethod.ecommerce.utils;

import java.util.List;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseWrapper <T>{
	
 @NonNull	
 private T body;
 private List<String> error;
}
