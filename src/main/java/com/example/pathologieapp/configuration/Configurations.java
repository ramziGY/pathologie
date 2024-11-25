package com.example.pathologieapp.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Getter
@Setter
@ConfigurationProperties
public class Configurations {

    private Map<Integer, String> pathologies;
}