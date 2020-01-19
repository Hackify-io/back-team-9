package com.digital_lab.hackify.ad_tech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_lab.hackify.ad_tech.domain.dto.CampaignDto;
import com.digital_lab.hackify.ad_tech.domain.model.Campaign;
import com.digital_lab.hackify.ad_tech.repository.CampaignRepository;
import com.digital_lab.hackify.ad_tech.service.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService{
	
	@Autowired
	CampaignRepository adRepository;

	@Override
	public Campaign getById(Long id) {
		return adRepository.getOne(id);
	}

	@Override
	public List<Campaign> getAll() {
		return adRepository.findAll();
	}

	@Override
	public Campaign save(CampaignDto campaignDto) {
		Campaign ad = new Campaign(campaignDto.getName(),campaignDto.getObjective(),campaignDto.getSpecialAdCategory(),
				campaignDto.getStatus());
		return adRepository.save(ad);
	}

}
