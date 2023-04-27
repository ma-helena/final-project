package com.example.userapi.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document
public class User {
    @Id
    String id;
    String name;
    String email;
    String password;

}
