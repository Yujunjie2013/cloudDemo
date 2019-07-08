package com.taotao.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Yune
 * @Date 2019/7/8 21:18
 * @Version
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class AppGateway {
    public static void main(String[] args) {
        SpringApplication.run(AppGateway.class, args);
    }
}
