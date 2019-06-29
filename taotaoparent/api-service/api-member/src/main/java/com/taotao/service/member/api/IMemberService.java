package com.taotao.service.member.api;

import com.taotao.service.member.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther Yune
 * @Date 2019/6/29 18:31
 * @Version 1.0
 * @Description
 */
public interface IMemberService {
    @GetMapping("/getMember")
    UserEntity getMember(@RequestParam("name") String name);
}
