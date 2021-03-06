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

import com.digital_lab.hackify.ad_tech.domain.dto.CampaignDto;
import com.digital_lab.hackify.ad_tech.domain.model.Campaign;
import com.digital_lab.hackify.ad_tech.service.CampaignService;

@RestController
@RequestMapping(path = "/campaigns", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin
public class CampaignController {
	
	@Autowired
	CampaignService campaignService;
	
	@GetMapping("")
	public List<Campaign> getCampaigns(@PathVariable Long id) {
		return campaignService.getAll();
	}

	@GetMapping("/{id}")
	public Campaign getCampaign(@PathVariable Long id) {
		return campaignService.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Campaign save(@RequestBody CampaignDto campaignDto) {
		return campaignService.save(campaignDto);
	}
	


}
