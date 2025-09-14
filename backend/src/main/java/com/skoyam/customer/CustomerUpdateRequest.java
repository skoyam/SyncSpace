package com.skoyam.customer;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age
) {
}
