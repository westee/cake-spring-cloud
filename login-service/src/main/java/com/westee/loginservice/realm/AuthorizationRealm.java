package com.westee.loginservice.realm;

import com.westee.loginservice.generate.Role;
import com.westee.loginservice.generate.User;
import com.westee.loginservice.service.MenuService;
import com.westee.loginservice.service.RoleService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorizationRealm extends AuthorizingRealm {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object principal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        /**
         * 这个语句使用了Java 14中引入的新特性，叫做“模式实例化”。
         * 它的作用是在判断principal是否是User类的实例的同时，将其强制转换为User类型，
         * 并赋值给userLogin变量。
         * 这样可以在当前作用域内直接使用userLogin变量，而不需要额外的代码来进行类型转换。
         */
        if (principal instanceof User userLogin) {
            List<Role> roleList = roleService.findByUserid(userLogin.getId());
            // 判断roleList是否为空
            if(!roleList.isEmpty()){
                for(Role role : roleList){
                    info.addRole(role.getName());

//                        List<Menu> menuList = menuService.getAllMenuByRoleId(role.getId());
//                        if(CollectionUtils.isNotEmpty(menuList)){
//                            for (Menu menu : menuList){
//                                if(StringUtils.isNoneBlank(menu.getPermission())){
//                                    info.addStringPermission(menu.getPermission());
//                                }
//                            }
//                        }
                }
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
