package com.taotao.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Yune
 * @Date 2019/7/1 23:06
 * @Version
 * @Description
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class GkConfig {
//    @EnableConfigServer开启配置，https://gitee.com/yujunjie666/fenbushipeizhiwenjian/tree/master/gkconfig
//    配置文件的命令规则是，服务名称-环境名称.properties，
    public static void main(String[] args) {
        SpringApplication.run(GkConfig.class, args);
    }
}
