package com.comic.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableFeignClients
@EnableWebSecurity
public class ManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageApplication.class, args);
	}

}
