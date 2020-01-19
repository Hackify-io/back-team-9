package com.digital_lab.hackify.ad_tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital_lab.hackify.ad_tech.domain.model.Ad;

public interface AdRepository extends JpaRepository<Ad,Long>{

}
