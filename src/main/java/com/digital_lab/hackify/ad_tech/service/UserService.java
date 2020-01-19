package com.digital_lab.hackify.ad_tech.service;

import com.digital_lab.hackify.ad_tech.domain.model.User;

public interface UserService {

	User save (final User user);
	
	User getByEmail(final String email);

	User getById(Long id);
}
