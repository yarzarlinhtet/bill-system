package com.codingassigment.billingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BillingSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(BillingSystemApplication.class, args);
	}

}
