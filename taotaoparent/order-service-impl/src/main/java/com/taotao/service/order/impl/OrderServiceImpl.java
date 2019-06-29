package com.taotao.service.order.impl;

import com.taotao.common.vo.ResponseBase;
import com.taotao.service.member.entity.UserEntity;
import com.taotao.service.order.IOrderService;
import com.taotao.service.order.feign.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yune
 * @Date 2019/6/29 19:57
 * @Version
 * @Description
 */
@RestController
public class OrderServiceImpl implements IOrderService {
    //订单服务继承会员服务接口，用来实现feign客户端,减少重复接口代码
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @GetMapping("/orderToMember")
    public String orderToMember(@RequestParam("name") String name) {
        UserEntity member = memberServiceFeign.getMember(name);
        return member == null ? "用户信息为空" : member.toString();
    }

    @GetMapping("/orderToMemberGetUserInfo")
    public ResponseBase orderToMemberGetUserInfo() {
        return memberServiceFeign.getUserInfo();
    }
}
