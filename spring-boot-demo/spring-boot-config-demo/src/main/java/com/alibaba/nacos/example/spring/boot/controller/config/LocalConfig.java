package com.alibaba.nacos.example.spring.boot.controller.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


import lombok.Data;


@Configuration
@ConfigurationProperties(prefix = "local")
@Data
public class LocalConfig {
        private boolean booleanConfig;
    private String stringConfig;
    private Integer integerConfig;
    private Double doubleConfig;

    private List<Object> listConfig;
    private Map<String, Object> mapConfig;
}
