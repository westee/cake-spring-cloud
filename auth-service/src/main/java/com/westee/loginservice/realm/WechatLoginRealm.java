package com.westee.loginservice.realm;

import com.westee.loginservice.generate.User;
import com.westee.loginservice.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class WechatLoginRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    Logger log = LoggerFactory.getLogger(WechatLoginRealm.class);

    @Override
    public String getName() {
        return LoginType.WECHAT_LOGIN.getType();
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        if (token instanceof UserToken) {
            return ((UserToken) token).getLoginType() == LoginType.WECHAT_LOGIN;
        } else {
            return false;
        }
    }

    @Override
    public void setAuthorizationCacheName(String authorizationCacheName) {
        super.setAuthorizationCacheName(authorizationCacheName);
    }

    @Override
    protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     * subject.login(token) 时调用
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UserToken token = (UserToken) authcToken;
        String code = token.getCode();

        String openid = token.getUsername();

        if(StringUtils.hasLength(openid)){
            log.error("微信授权登录失败，未获得openid");
            throw new AuthenticationException();
        }
        User user = userService.getByOpenid(openid);

        // 完成登录，此处已经不需要做密码校验
        return new SimpleAuthenticationInfo(
                user, //用户
                code, //密码
                getName()  //realm name
        );
    }

    private String getOpenid(String code){
        // 这里假装是一个通过code获取openid的方法，具体实现由各位自己去实现，此处不做扩展
        if(StringUtils.hasLength(code)){
            return "sdfuh81238917jhoijiosdsgsdfljiofds";
        }
        return null;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
