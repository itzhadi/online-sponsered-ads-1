package com.online.ads.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.ads.dto.GetServeAdRequest;
import com.online.ads.dto.GetServeAdResponse;
import com.online.ads.model.PromotedProduct;
import com.online.ads.repository.CampaignRepository;
import com.online.ads.utils.DateUtils;



@RestController
public class ServeAdController {
	
	@Autowired
	private CampaignRepository campaignRepository;

	@GetMapping("/getServeAd")
	public PromotedProduct getServeAd(@RequestBody GetServeAdRequest request) {

		List<GetServeAdResponse> serveAdResList = campaignRepository.getServeAd();
		PromotedProduct promotedProduct = new PromotedProduct();
		Integer higestBid = -1;
		int promotedProductIndex = -1;
		int index = -1;
		for (GetServeAdResponse serveAd : serveAdResList) {
			index++;
			if (serveAd.getCategory().equals(request.getCategory()) && isActiveCampaign(serveAd.getStartDate())) {
				if (serveAd.getBid() > higestBid) {
					higestBid = serveAd.getBid();
					promotedProductIndex = index;
				}
			}
		}

		if (promotedProductIndex > -1) {
			promotedProduct = mapPromotedProduct(serveAdResList.get(promotedProductIndex));
		} else {
			promotedProduct = getHighestPromotedProductBid(serveAdResList);
		}

		return promotedProduct;
	}

	private PromotedProduct getHighestPromotedProductBid(List<GetServeAdResponse> serveAdResList) {
		Integer higestBid = -1;
		int higestPrice = -1;
		int index = -1;
		int promotedProductIndex = -1;
		for (GetServeAdResponse serveAd : serveAdResList) {
			index++;
			if (serveAd.getBid() >= higestBid && serveAd.getPrice() > higestPrice) {
				higestBid = serveAd.getBid();
				higestPrice = serveAd.getPrice();
				promotedProductIndex = index;
			}
		}

		return mapPromotedProduct(serveAdResList.get(promotedProductIndex));

	}

	private PromotedProduct mapPromotedProduct(GetServeAdResponse serveAd) {
		PromotedProduct promotedProduct = new PromotedProduct();
		promotedProduct.setCategory(serveAd.getCategory());
		promotedProduct.setPrice(serveAd.getPrice());
		promotedProduct.setTitle(serveAd.getTitle());
		promotedProduct.setProductSerialNumber(serveAd.getProductSerialNumber());

		return promotedProduct;
	}

	private boolean isActiveCampaign(Date startDate) {
		LocalDate convertedStartDate = DateUtils.convertToLocalDateViaInstant(startDate);
		LocalDate currentDate = LocalDate.now();
		LocalDate dateMinus10 = currentDate.minusDays(10);
		return convertedStartDate.equals(currentDate)
				|| (convertedStartDate.isBefore(currentDate) && convertedStartDate.isAfter(dateMinus10));
	}

}
