package com.alibaba.nacos.example.spring.boot.controller.config;


import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;

import lombok.Data;

@Configuration
@Data
@NacosConfigurationProperties(dataId = "demo-config", groupId = "spring-boot", autoRefreshed = true, prefix = "dynamic")
public class ObjConfig {
    private boolean booleanConfig;
    private String stringConfig;
    private Integer integerConfig;
    private Double doubleConfig;

    private List<Object> listConfig;
    private Map<String, Object> mapConfig;
}
