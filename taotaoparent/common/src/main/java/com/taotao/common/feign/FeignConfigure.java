package com.taotao.common.feign;

import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yune
 * @Date 2019/6/29 23:04
 * @Version
 * @Description
 */
@Configuration
public class FeignConfigure {
    //超时时间
    private static final int CONNECT_TIMEOUTMILLIS = 12000;
    private static final int READ_TIMEOUTMILLIS = 12000;

    @Bean
    public Request.Options options() {
        return new Request.Options(CONNECT_TIMEOUTMILLIS, READ_TIMEOUTMILLIS);
    }

    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default();
    }
}
