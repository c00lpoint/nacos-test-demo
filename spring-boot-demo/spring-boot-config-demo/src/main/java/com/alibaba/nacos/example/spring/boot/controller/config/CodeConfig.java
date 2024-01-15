package com.alibaba.nacos.example.spring.boot.controller.config;


import org.springframework.context.annotation.Configuration;

import com.alibaba.nacos.api.config.annotation.NacosValue;

import lombok.Data;

@Data
@Configuration
public class CodeConfig {

    @NacosValue(value = "${dynamic.booleanConfig:false}", autoRefreshed = true)
    private boolean dynamicBooleanConfig;
    @NacosValue(value = "${dynamic.stringConfig:}", autoRefreshed = true)
    private String dynamicStringConfig;
    @NacosValue(value = "${dynamic.integerConfig:0}", autoRefreshed = true)
    private Integer dynamicIntegerConfig;
    @NacosValue(value = "${dynamic.doubleConfig:0}", autoRefreshed = true)
    private Double dynamicDoubleConfig;
    // @NacosValue(value = "${dynamic.listConfig:}", autoRefreshed = true)
    // private List<Object> dynamicListConfig;
    // @NacosValue(value = "${dynamic.mapConfig:}", autoRefreshed = true)
    // private Map<String, Object> dynamicMapConfig;

    // @NacosValue(value = "${static.booleanConfig:false}")
    // private boolean staticBooleanConfig;
    // @NacosValue(value = "${static.stringConfig:}")
    // private String staticStringConfig;
    // @NacosValue(value = "${static.integerConfig:0}")
    // private Integer staticIntegerConfig;
    // @NacosValue(value = "${static.doubleConfig:0}")
    // private Double staticDoubleConfig;
    // @NacosValue(value = "${static.listConfig:}")
    // private List<Object> staticListConfig;
    // @NacosValue(value = "${static.mapConfig:}")
    // private Map<String, Object> staticMapConfig;
}
