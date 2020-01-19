package com.digital_lab.hackify.ad_tech.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Ad {

	public Ad(String description, String imagePath, String url) {
		super();
		this.description = description;
		this.imagePath = imagePath;
		this.url = url;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String imagePath;

	private String url;
}
