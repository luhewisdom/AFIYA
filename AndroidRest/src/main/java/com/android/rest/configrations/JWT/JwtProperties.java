package com.android.rest.configrations.JWT;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {
    private String secretKey = "secret";

    //validity in milliseconds
    private long validityInMs = 3600000; // 1h
}
