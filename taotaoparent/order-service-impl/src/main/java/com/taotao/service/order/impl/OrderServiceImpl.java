package com.taotao.service.order.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.taotao.common.baseservice.BaseApiService;
import com.taotao.common.vo.ResponseBase;
import com.taotao.service.member.entity.UserEntity;
import com.taotao.service.order.IOrderService;
import com.taotao.service.order.feign.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Yune
 * @Date 2019/6/29 19:57
 * @Version
 * @Description
 */
@RestController
@RefreshScope
public class OrderServiceImpl extends BaseApiService implements IOrderService {
    //订单服务继承会员服务接口，用来实现feign客户端,减少重复接口代码
//    @Qualifier("member-service-impl")

    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @Value("${com.appkey}")
    private String appkey;
    @Value("${com.appId}")
    private String appId;


    @Override
    @GetMapping("/orderToMember")
    public String orderToMember(@RequestParam("name") String name) {
        UserEntity member = memberServiceFeign.getMember(name);
        return member == null ? "用户信息为空" + appId + "-->appkey:" + appkey : member.toString() + "appId:" + appId + "---appkey:" + appkey;
    }


    @Override
    @GetMapping("/orderToMemberGetUserInfo")
    public ResponseBase orderToMemberGetUserInfo() {
        System.out.println("orderToMemberGetUserInfo当前线程：" + Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }

    /**
     * HystrixCommand 开启断路器,fallbackMethod表示熔断时回调方法
     * 默认开启服务隔离方式，以线程池方式
     * 默认开启服务降级执行、执行orderToMemberGetUserInfoFallBack
     * 默认开启服务熔断机制
     *
     * @return 实体
     */
    @Override
    @HystrixCommand(fallbackMethod = "orderToMemberGetUserInfoFallBack")
    @GetMapping("/orderToMemberGetUserInfoForHystrix")
    public ResponseBase orderToMemberGetUserInfoForHystrix() {
        System.out.println("开始业务：" + Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }

    public ResponseBase orderToMemberGetUserInfoFallBack() {
        System.out.println("熔断：" + Thread.currentThread().getName());
        return setResultError("当前请求人数过多，请稍后再试!");
    }

    /**
     * 以第二种方式演示服务降级，使用类的方式
     *
     * @return
     */
    @GetMapping("/orderToMemberGetUserInfoForHystrix2")
    public ResponseBase orderToMemberGetUserInfoForHystrix2() {
        System.out.println("开始业务：" + Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }


    @Override
    @GetMapping("/getOrderInfo")
    public ResponseBase getOrderInfo() {
        System.out.println("getOrderInfo当前线程：" + Thread.currentThread().getName());
        return setResultSuccess("手机订单");
    }

    @Override
    @GetMapping("/getError")
    public ResponseBase getError() {
        System.out.println("错误的信息：" + Thread.currentThread().getName());
        return memberServiceFeign.getErrorInfo();
    }
}
