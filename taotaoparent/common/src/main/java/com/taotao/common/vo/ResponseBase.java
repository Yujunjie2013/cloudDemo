package com.taotao.common.vo;

import lombok.Data;

/**
 * @author Yune
 * @Date 2019/6/29 22:29
 * @Version
 * @Description
 */
@Data
public class ResponseBase {
    private Integer code;
    private String msg;
    private Object data;

    public ResponseBase() {
    }

    public ResponseBase(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseBase{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
