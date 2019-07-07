package com.android.rest.api;

import lombok.Data;

@Data
public class LoginResponse {

    private String username;

    private String token;
}
