package com.digital_lab.hackify.ad_tech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_lab.hackify.ad_tech.domain.dto.AdDto;
import com.digital_lab.hackify.ad_tech.domain.model.Ad;
import com.digital_lab.hackify.ad_tech.repository.AdRepository;
import com.digital_lab.hackify.ad_tech.service.AdService;

@Service
public class AdServiceImpl implements AdService{
	
	@Autowired
	AdRepository adRepository;

	@Override
	public Ad getById(Long id) {
		return adRepository.getOne(id);
	}

	@Override
	public List<Ad> getAll() {
		return adRepository.findAll();
	}

	@Override
	public Ad save(AdDto adDto) {
		Ad ad = new Ad(adDto.getDescription(),adDto.getImagePath(),adDto.getUrl());
		return adRepository.save(ad);
	}

}
