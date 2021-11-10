package com.online.ads.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

	@Id
	private int productId;
	private String title;
	private String category;
	private Integer price;
	private Integer productSerialNumber;
}
