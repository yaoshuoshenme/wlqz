package com.edu.wlqz.realm;

import com.edu.wlqz.pojo.Admin;
import com.edu.wlqz.service.ResourceService;
import commons.R;
import jdk.nashorn.api.scripting.ScriptUtils;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRealm extends AuthorizingRealm {
    @Autowired
    private ResourceService service;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Admin admin = (Admin) SecurityUtils.getSubject().getSession().getAttribute("admin");
        List<String> resources = (List<String>) service.selectByUid(admin.getId()).getData();
        info.addStringPermissions(resources);
        return info;
    }

    //校验
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token.getUsername(),token.getPassword(),getName());
        return info;
    }
}
