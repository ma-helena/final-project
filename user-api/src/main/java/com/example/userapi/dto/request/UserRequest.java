package com.example.userapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Data
public class UserRequest {String id;
                           String email;
                           String name;
                           String password;
}
