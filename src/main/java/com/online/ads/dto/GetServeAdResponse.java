package com.online.ads.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetServeAdResponse {
	
	private Date startDate;
	private Integer bid;
	private String campaignName;
	private String title;
	private String category;
	private Integer price;
	private Integer productSerialNumber;

}
