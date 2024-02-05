package com.westee.goodsservice.redis;

import com.westee.common.entity.Response;
import com.westee.common.entity.ResponseMessage;
import com.westee.common.entity.User;
import com.westee.common.exception.HttpException;
import com.westee.goodsservice.service.TokenContext;
import com.westee.openfeign.client.RoleServiceProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 负责读写Redis中的用户信息
 * 如果没有对应信息则尝试从auth模块中获取用户信息
 */
@Service
public class UserRedisService {
    private final RedisTemplate<String, Object> redisTemplate;
    private final RoleServiceProviderClient roleServiceProviderClient;

    @Autowired
    public UserRedisService(RedisTemplate<String, Object> redisTemplate, RoleServiceProviderClient roleServiceProviderClient) {
        this.redisTemplate = redisTemplate;
        this.roleServiceProviderClient = roleServiceProviderClient;
    }

    public void setUser() {
        User userFromAuth = getUserFromAuthModule();
        redisTemplate.opsForValue().set(concatRedisKey(), userFromAuth);
    }

    public User getUser() {
        String key = concatRedisKey();
        if (Boolean.FALSE.equals(redisTemplate.hasKey(key))) {
            setUser();
        }
        // 从redis读取用户信息
        User user = (User) redisTemplate.opsForValue().get(key);
        if (Objects.isNull(user)) {
            return getUserFromAuthModule();
        }
        return user;
    }

    public User getUserFromAuthModule() {
        String currentToken = TokenContext.getCurrentToken();
        if (Objects.isNull(currentToken)) {
            throw HttpException.notAuthorized("尚未登录");
        }
        Response<User> userFromAuth = roleServiceProviderClient.getUser(currentToken);
        if (Objects.equals(userFromAuth.getMessage(), ResponseMessage.OK.toString()) &&
                Objects.nonNull(userFromAuth.getData())) {
            return userFromAuth.getData();
        }
        throw HttpException.notAuthorized("尚未登录");
    }

    public String concatRedisKey() {
        return "user:" + TokenContext.getCurrentToken() + ":permission";
    }

}
