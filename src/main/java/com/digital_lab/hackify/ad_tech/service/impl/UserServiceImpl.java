package com.digital_lab.hackify.ad_tech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_lab.hackify.ad_tech.domain.model.User;
import com.digital_lab.hackify.ad_tech.repository.UserRepository;
import com.digital_lab.hackify.ad_tech.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User getById(Long id) {
		return userRepository.getOne(id);
	}

}
