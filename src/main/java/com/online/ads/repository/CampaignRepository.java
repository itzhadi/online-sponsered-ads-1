package com.online.ads.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.online.ads.dto.GetServeAdResponse;
import com.online.ads.model.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Integer>{
	
	@Query("SELECT new com.online.ads.dto.GetServeAdResponse(c.startDate , c.bid , c.campaignName , p.title , p.category , p.price , p.productSerialNumber)" + " FROM Campaign c JOIN c.products p")
	public List<GetServeAdResponse> getServeAd();

}
