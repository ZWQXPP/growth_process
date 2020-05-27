package com.leyou.config;

import com.leyou.properties.CorsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

/**
 * @program: leyou_99
 * @description: 拦截到请求后，给响应头设置信息（允许跨域）
 **/
@Configuration
public class CorsConfig {

    @Autowired
    private CorsProperties prop;

    //响应头设置信息
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        List<String> allowedOrigins = prop.getAllowedOrigins();

        //1.允许跨域 域名 manage.leyou.com
       /* for (String allowedOrigin : allowedOrigins) {
            corsConfiguration.addAllowedOrigin(allowedOrigin);
        }*/
       allowedOrigins.stream().forEach(corsConfiguration::addAllowedOrigin);

        //2.允许访问方式 GET，PUT...
        prop.getAllowedMethods().stream().forEach(corsConfiguration::addAllowedMethod);


        //3.允许提交头信息
      prop.getAllowedHeaders().stream().forEach(corsConfiguration::addAllowedHeader);

        //4.是否允许操作cookie
        corsConfiguration.setAllowCredentials(prop.getAllowedCredentials());

        //5.设置预检请求有效期
        corsConfiguration.setMaxAge(prop.getMaxAge());

        //配置对象：配置拦截请求路径,设置响应头信息
        UrlBasedCorsConfigurationSource config = new UrlBasedCorsConfigurationSource();
        config.registerCorsConfiguration(prop.getFilterPath(), corsConfiguration);
        return new CorsFilter(config);
    }

}
