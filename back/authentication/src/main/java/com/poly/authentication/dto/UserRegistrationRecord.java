package com.poly.authentication.dto;

public record UserRegistrationRecord(String username, String email, String password, String firstName, String lastName) {
}
