package com.skoyam.auth;

import com.skoyam.customer.CustomerDTO;

public record AuthResponse(
        String token,
        CustomerDTO customerDTO){
}
