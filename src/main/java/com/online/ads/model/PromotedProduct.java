package com.online.ads.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromotedProduct {
	
	private String title;
	private String category;
	private Integer price;
	private Integer productSerialNumber;

}
