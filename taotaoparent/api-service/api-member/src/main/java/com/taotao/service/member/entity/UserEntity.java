package com.taotao.service.member.entity;

import lombok.Data;

/**
 * @Auther Yune
 * @Date 2019/6/29 18:35
 * @Version
 * @Description
 */
@Data
public class UserEntity {
    private String userName;
    private int age;

    @Override
    public String toString() {
        return "UserEntity{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
