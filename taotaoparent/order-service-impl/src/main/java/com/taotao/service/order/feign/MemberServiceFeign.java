package com.taotao.service.order.feign;

import com.taotao.service.member.api.IMemberService;
import com.taotao.service.order.fallback.MemberServiceFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Yune
 * @Date 2019/6/29 20:07
 * @Version 1.0
 * @Description
 */

@FeignClient(value = "member-service-impl", fallback = MemberServiceFeignFallback.class)
public interface MemberServiceFeign extends IMemberService {
}
