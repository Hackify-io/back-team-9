package com.digital_lab.hackify.ad_tech.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Campaign {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String status;
	
	private String specialAdCategory;
	
	private String objective;

	public Campaign(String name, String status, String specialAdCategory, String objective) {
		super();
		this.name = name;
		this.status = status;
		this.specialAdCategory = specialAdCategory;
		this.objective = objective;
	}
	
	
}
