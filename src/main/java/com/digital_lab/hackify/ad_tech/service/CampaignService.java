package com.digital_lab.hackify.ad_tech.service;

import java.util.List;

import com.digital_lab.hackify.ad_tech.domain.dto.CampaignDto;
import com.digital_lab.hackify.ad_tech.domain.model.Campaign;

public interface CampaignService {

	Campaign getById(Long id);

	List<Campaign> getAll();

	Campaign save(CampaignDto campaignDto);

}
