package com.example.userapi.dto.response;

import lombok.Builder;

@Builder
public record UserResponse ( String name,
        String id,
        String email,
        String password ){

}
