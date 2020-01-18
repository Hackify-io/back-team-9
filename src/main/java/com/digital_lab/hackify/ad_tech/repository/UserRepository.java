package com.digital_lab.hackify.ad_tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital_lab.hackify.ad_tech.domain.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User getByEmail(String email);

}
