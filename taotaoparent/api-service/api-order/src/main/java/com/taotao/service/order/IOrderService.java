package com.taotao.service.order;

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
}
