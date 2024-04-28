package com.poly.feedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestFeedbackApplication {

	public static void main(String[] args) {
		SpringApplication.from(FeedbackApplication::main).with(TestFeedbackApplication.class).run(args);
	}

}
