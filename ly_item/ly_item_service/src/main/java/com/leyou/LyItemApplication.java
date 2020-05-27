package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: leyou_99
 * @description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
@tk.mybatis.spring.annotation.MapperScan("com.leyou.item.mapper")  //扫描到持久层接口后，产生代理对象
public class LyItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LyItemApplication.class, args);
    }
}
