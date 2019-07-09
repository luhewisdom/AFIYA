package com.android.rest.domain;

import lombok.Data;

@Data
public class LoginResponse {

    private String username;

    private String token;
}
