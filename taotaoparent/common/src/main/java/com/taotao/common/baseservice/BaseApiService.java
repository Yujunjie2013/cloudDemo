package com.taotao.common.baseservice;

import com.taotao.common.vo.ResponseBase;
import org.springframework.stereotype.Component;

/**
 * @author Yune
 * @Date 2019/6/29 22:33
 * @Version
 * @Description
 */
@Component
public class BaseApiService {
    public ResponseBase setResultError(Integer code, String msg) {
        return setResult(code, msg, null);
    }

    public ResponseBase setResultError(String msg) {
        return setResult(500, msg, null);
    }

    public ResponseBase setResultSuccess(Object object) {
        return setResult(200, "请求成功", object);
    }

    public ResponseBase setResultSuccess() {
        return setResult(200, "请求成功", null);
    }

    public ResponseBase setResultSuccess(String msg) {
        return setResult(200, msg, null);
    }

    private ResponseBase setResult(Integer code, String msg, Object data) {
        return new ResponseBase(code, msg, data);
    }
}
