package com.online.ads.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.ads.dto.CreateCampaignReq;
import com.online.ads.model.Campaign;
import com.online.ads.repository.CampaignRepository;
import com.online.ads.utils.DateUtils;

@RestController
public class CreateCampaignController {
	
	@Autowired
	private CampaignRepository campaignRepository;

	@PostMapping("/createCampaign")
	public Campaign createCampaign(@RequestBody CreateCampaignReq request) {

		Date parsedDate = DateUtils.parseDate(request.getCampaign().getStartDate().getTime());
		request.getCampaign().setStartDate(parsedDate);
		return campaignRepository.save(request.getCampaign());
	}

	@GetMapping("/getAllCampaigns")
	public List<Campaign> getAllCampaigns() {

		return campaignRepository.findAll();
	}
	
	@DeleteMapping("/deleteAllCampaigns")
	public void deleteAllCampaigns() {

		campaignRepository.deleteAll();
	}

}
