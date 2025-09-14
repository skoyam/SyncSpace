package com.skoyam.auth;

public record AuthRequest(
        String username,
        String password
) {
}
