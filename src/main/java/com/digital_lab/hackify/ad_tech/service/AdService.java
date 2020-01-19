package com.digital_lab.hackify.ad_tech.service;

import java.util.List;

import com.digital_lab.hackify.ad_tech.domain.dto.AdDto;
import com.digital_lab.hackify.ad_tech.domain.model.Ad;

public interface AdService {

	Ad getById(Long id);

	List<Ad> getAll();

	Ad save(AdDto adDto);

}
