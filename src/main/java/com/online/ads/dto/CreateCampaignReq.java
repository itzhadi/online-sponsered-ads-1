package com.online.ads.dto;


import com.online.ads.model.Campaign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateCampaignReq {
	
	private Campaign campaign;

}
