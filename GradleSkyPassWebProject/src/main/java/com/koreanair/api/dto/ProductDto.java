package com.koreanair.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
	private int seq;
	private String name; 
	private int price; 
	private int quantity;

	

}
