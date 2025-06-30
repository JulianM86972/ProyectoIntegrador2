package com.controlapp.ControlApp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private String secretKey = "ClaveSecretaParaProyectoIntegradorII1234567890!@#$%^&*";
    private long validityInMs = 604800000; // 7 dias
}