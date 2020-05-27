package com.leyou.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: leyou_99
 * @description:
 **/
@Data
//@EnableConfigurationProperties(CorsProperties.class)
@Component
@ConfigurationProperties("ly.cors")
public class CorsProperties {

    private List<String> allowedOrigins;
    private Boolean allowedCredentials;
    private List<String> allowedMethods;
    private List<String> allowedHeaders;
    private Long maxAge;
    private String filterPath;
}
