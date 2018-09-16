package com.assessment.RetailStoreDiscountAssessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.assessment.RetailStoreDiscountAssessment",
		"com.assessment.RetailStoreDiscountAssessment.controller",
		"com.assessment.RetailStoreDiscountAssessment.service" })
public class RetailStoreDiscountAssessmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(RetailStoreDiscountAssessmentApplication.class, args);
	}
}
