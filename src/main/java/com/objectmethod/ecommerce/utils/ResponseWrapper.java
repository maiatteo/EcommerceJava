package com.objectmethod.ecommerce.utils;

import java.util.List;

import lombok.Data;

@Data
public class ResponseWrapper <T>{
 private T body;
 private List<String> error;
}
