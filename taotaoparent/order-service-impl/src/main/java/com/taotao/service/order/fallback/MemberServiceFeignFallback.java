package com.taotao.service.order.fallback;

import com.taotao.common.baseservice.BaseApiService;
import com.taotao.common.vo.ResponseBase;
import com.taotao.service.member.entity.UserEntity;
import com.taotao.service.order.feign.MemberServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceFeignFallback extends BaseApiService implements MemberServiceFeign {
    @Override
    public UserEntity getMember(String name) {
        return null;
    }

    @Override
    public ResponseBase getUserInfo() {
        return setResultError("服务器忙，请稍后再试，以类的方式实现服务降级");
    }

    @Override
    public ResponseBase getErrorInfo() {
        System.out.println("MemberServiceFeignFallback服务降级:" + Thread.currentThread().getName());
        return setResultError("服务降级成功，以类的方式。");
    }
}
