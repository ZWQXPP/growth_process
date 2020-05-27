package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: leyou_99
 * @description:
 **/
@SpringBootApplication
@EnableEurekaServer
public class LyRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyRegistryApplication.class, args);
    }
}
