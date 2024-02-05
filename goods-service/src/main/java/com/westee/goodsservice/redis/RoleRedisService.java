package com.westee.goodsservice.redis;

import com.westee.common.entity.Response;
import com.westee.common.entity.ResponseMessage;
import com.westee.common.entity.Role;
import com.westee.common.exception.HttpException;
import com.westee.goodsservice.service.TokenContext;
import com.westee.openfeign.client.RoleServiceProviderClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 负责读写Redis中的用户Role信息
 * 如果没有对应信息则尝试从auth模块中获取用户Role信息
 */
@Service
public class RoleRedisService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final RoleServiceProviderClient roleServiceProviderClient;

    public RoleRedisService(RedisTemplate<String, Object> redisTemplate,
                            RoleServiceProviderClient roleServiceProviderClient) {
        this.redisTemplate = redisTemplate;
        this.roleServiceProviderClient = roleServiceProviderClient;
    }

    public void setUserRole(String token) {
        Role userRoleFromAuthModule = getUserRoleFromAuthModule();
        redisTemplate.opsForValue().set(concatRedisKey(token), userRoleFromAuthModule);
    }

    public Role getUserRole() {
        String key = concatRedisKey(TokenContext.getCurrentToken());
        if (Boolean.FALSE.equals(redisTemplate.hasKey(key))) {
            setUserRole(key);
        }
        // 从redis中读取信息
        Role role = (Role) redisTemplate.opsForValue().get(key);
        if (Objects.isNull(role)) {
            return getUserRoleFromAuthModule();
        }
        return role;
    }

    public Role getUserRoleFromAuthModule() {
        String currentToken = TokenContext.getCurrentToken();
        if (Objects.isNull(currentToken)) {
            throw HttpException.notAuthorized("没有权限获取角色信息");
        }
        Response<Role> roleFromAuth = roleServiceProviderClient.getRole(currentToken);
        if (Objects.equals(roleFromAuth.getMessage(), ResponseMessage.OK.toString()) &&
                Objects.nonNull(roleFromAuth.getData())) {
            return roleFromAuth.getData();
        }
        throw HttpException.notAuthorized("没有权限获取角色信息");
    }

    public String concatRedisKey(String username) {
        return "role:" + username + ":permission";
    }

}
