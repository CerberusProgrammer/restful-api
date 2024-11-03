package com.example.restful_api.user;

import lombok.Data;

@Data
public class UserQueryParams {
    private String name;
    private String email;
}