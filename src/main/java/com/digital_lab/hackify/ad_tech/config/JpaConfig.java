package com.digital_lab.hackify.ad_tech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.digital_lab.hackify.ad_tech.util.UsernameAuditableProvider;

@Configuration
@EnableJpaRepositories(basePackages = "com.digital_lab.hackify.ad_tech")
@EnableJpaAuditing(auditorAwareRef = "usernameAuditableProvider")
public class JpaConfig {

	// <bean id="usernameAuditableProvider"
	// class="com.softtek.academy.jpa.util.UsernameAuditableProvider"/>
	@Bean("usernameAuditableProvider")
	AuditorAware<String> usernameAuditableProvider() {
		return new UsernameAuditableProvider();
	}

}