package com.digital_lab.hackify.ad_tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digital_lab.hackify.ad_tech.domain.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	@Query(value = "SELECT u.* FROM [dbo].[USER] u WHERE u.email=:email", 
			  nativeQuery = true)
	User findByEmail(final String email);

}
