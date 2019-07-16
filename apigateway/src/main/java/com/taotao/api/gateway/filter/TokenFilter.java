package com.taotao.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }


    public boolean shouldFilter() {
        return true;
    }

    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //从请求头中获取token
        String token1 = request.getHeader("token");
        String token = request.getParameter("token");
        //如果token为null，则表明没有token，不会继续调用服务接口，网关服务器直接响应给客户端
        if (StringUtils.isEmpty(token)) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("Token is null");
            currentContext.setResponseStatusCode(401);
            return null;
        }
        //正常执行调用其他服务接口
        return null;
    }
}
