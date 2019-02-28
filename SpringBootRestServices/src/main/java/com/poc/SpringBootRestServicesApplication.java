package com.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(scanBasePackages= {"com.poc."})
@EnableAutoConfiguration(exclude={HibernateJpaAutoConfiguration.class})
public class SpringBootRestServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestServicesApplication.class, args);
	}

}

