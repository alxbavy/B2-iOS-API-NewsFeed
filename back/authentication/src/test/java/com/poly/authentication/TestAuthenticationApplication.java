package com.poly.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.from(AuthenticationApplication::main).with(TestAuthenticationApplication.class).run(args);
	}

}
