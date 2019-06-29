package com.taotao.service.member.impl.api;

import com.taotao.common.vo.ResponseBase;
import com.taotao.common.baseservice.BaseApiService;
import com.taotao.service.member.api.IMemberService;
import com.taotao.service.member.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yune
 * @Date 2019/6/29 18:38
 * @Description
 */
@RestController
public class MemberServiceImpl extends BaseApiService implements IMemberService {
    @GetMapping("/getMember")
    @Override
    public UserEntity getMember(@RequestParam("name") String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(18);
        userEntity.setUserName(name);
        return userEntity;
    }

    @GetMapping("/getUserInfo")
    @Override
    public ResponseBase getUserInfo() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return setResultSuccess();
    }
}
