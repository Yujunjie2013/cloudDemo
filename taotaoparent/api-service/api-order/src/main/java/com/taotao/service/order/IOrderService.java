package com.taotao.service.order;

import com.taotao.common.vo.ResponseBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Yune
 * @Date 2019/6/29 19:56
 * @Version
 * @Description
 */
public interface IOrderService {
    @GetMapping("/orderToMember")
    String orderToMember(@RequestParam("name") String name);

    /**
     * 订单接口调用会员服务接口
     * @return 实体对象
     */
    @GetMapping("/orderToMemberGetUserInfo")
    ResponseBase orderToMemberGetUserInfo();
}
