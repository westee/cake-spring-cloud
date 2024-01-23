package com.westee.loginservice.realm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.westee.loginservice.entity.Response;
import com.westee.loginservice.exceptions.HttpException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class JWTAuthFilter extends AuthenticatingFilter {
    // 创建一个logback 用来记录log
    private static final Logger log = LoggerFactory.getLogger(JWTAuthFilter.class);

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        //从请求头中获取token
        String token = getRequestToken((HttpServletRequest) request);
        if (StringUtils.hasLength(token)) {
            throw HttpException.notAuthorized("token不能为空"); //AuthenticationException("");
        }
        return new JWTToken(token);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //进行token校验
        try {
            JWTToken jwtToken = (JWTToken) this.createToken(request, response);
            SecurityUtils.getSubject().login(jwtToken);
        } catch (Exception e) {
            HttpServletResponse res = (HttpServletResponse) response;
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json;charset=UTF-8");
            String responseBody = objectMapper.writeValueAsString(Response.of("用户未授权", null));
            res.getWriter().write(responseBody);
            res.setStatus(401);
            return false;
        }
        return true;
    }

    //从请求头中获取token
    private String getRequestToken(HttpServletRequest request) {
        //从Header中获取token
        String token = request.getHeader("Token");
//        String token = request.getHeader("Authorization");
        if (StringUtils.hasLength(token)) {
//            token = token.substring(7);
        }
        return token;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        String token = getRequestToken((HttpServletRequest) request);
        if (StringUtils.hasLength(token)) {
            return false;
        }
        try {
            //验证token
            JWTUtil.verify(token); //调用JWTUtil工具类验证token
        } catch (Exception e) {
            log.error("token验证失败", e);
            return false;
        }
        return true;
    }
}
