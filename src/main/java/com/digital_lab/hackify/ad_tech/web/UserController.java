package com.digital_lab.hackify.ad_tech.web;

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

import com.digital_lab.hackify.ad_tech.domain.model.User;
import com.digital_lab.hackify.ad_tech.service.UserService;

@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public User save(@RequestBody User user) {
		return userService.save(user);
	}

}
