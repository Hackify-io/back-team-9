package com.digital_lab.hackify.ad_tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital_lab.hackify.ad_tech.domain.model.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign,Long>{

}
