package com.edu.wlqz.shiro;

import com.edu.wlqz.realm.AdminRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShrioConfig {
    //配置管理器
    @Bean
    public SecurityManager securityManager(AdminRealm adminRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(adminRealm);
        return securityManager;
    }

    //配置shiro过滤器
    @Bean
    public ShiroFilterFactoryBean shirofilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        shiroFilterFactoryBean.setSuccessUrl("index.html");
        shiroFilterFactoryBean.setLoginUrl("/page/login/login.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("unauthor.html");

        Map<String, String> map = new HashMap<>();
        map.put("/**","authc");
        map.put("/adminlogin.do","anon");
        map.put("/saveadmin.do","anon");
        map.put("/page/login/*","anon");
        map.put("/index.html","anon");
        map.put("/media/**","anon");
        map.put("/css/**","anon");
        map.put("/js/**","anon");
        map.put("/layui/**","anon");
        map.put("/images/**","anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }

    //配置拦截器
    public AuthorizationAttributeSourceAdvisor attributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor attributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        attributeSourceAdvisor.setSecurityManager(securityManager);

        return attributeSourceAdvisor;
    }
}
