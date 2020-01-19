package com.digital_lab.hackify.ad_tech.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digital_lab.hackify.ad_tech.domain.dto.AdDto;
import com.digital_lab.hackify.ad_tech.domain.model.Ad;
import com.digital_lab.hackify.ad_tech.service.AdService;

@RestController
@RequestMapping(path = "/ads", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin
public class AdController {
	
	@Autowired
	AdService adService;
	
	@GetMapping("")
	public List<Ad> getAds(@PathVariable Long id) {
		return adService.getAll();
	}

	@GetMapping("/{id}")
	public Ad getAd(@PathVariable Long id) {
		return adService.getById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ad save(@RequestBody AdDto adDto) {
		return adService.save(adDto);
	}


}
