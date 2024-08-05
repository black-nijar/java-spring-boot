package com.example.demo.user;

public record User(
    Integer id,
    String name,
    String username,
    Address address,
    String email,
    String phone,
    String website,
    Company company
) {
    
}
