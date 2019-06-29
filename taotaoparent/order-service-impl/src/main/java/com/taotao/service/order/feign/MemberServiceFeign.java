package com.taotao.service.order.feign;

import com.taotao.service.member.api.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Yune
 * @Date 2019/6/29 20:07
 * @Version 1.0
 * @Description
 */
@FeignClient("member-service-impl")
public interface MemberServiceFeign extends IMemberService {
}
