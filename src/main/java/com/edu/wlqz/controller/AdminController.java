package com.edu.wlqz.controller;

import com.edu.wlqz.pojo.Admin;
import com.edu.wlqz.service.AdminService;
import com.edu.wlqz.vo.PageVo;
import commons.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class AdminController {
    @Autowired
    private AdminService service;

    //登录
    @RequestMapping("/adminlogin.do")
    public R adminlogin(String name, String password, @RequestParam(defaultValue = "") String remberme, HttpServletRequest request){
        Admin admin = service.selectByName(name, password);
        if(admin != null){
            request.getSession().setAttribute("admin",admin);
            Subject subject = SecurityUtils.getSubject();
            boolean res = false;
            if(remberme.length() > 0){
                res = true;
            }
            UsernamePasswordToken token = new UsernamePasswordToken(name,password,res);
            subject.login(token);
            subject.getSession().setAttribute("admin",admin);

            return R.setOK();
        }
        return R.setERROR();
    }
    //删除
    @RequestMapping("/deladmin.do")
    public R deladmin(Integer id){
        if(service.deleteById(id)){
            return R.setOK();
        }
        return R.setERROR();
    }

    //分页
    @RequestMapping("/querybypage.do")
    public R querybypage(Integer page, Integer limit){
        PageVo pageVo = service.selectByPage(page, limit);
        if(null != pageVo){
            return new R(0,"ok",pageVo);
        }
        return R.setERROR();
    }
    //修改信息
    @RequestMapping("/modifyadmin.do")
    public R modifyadmin(Admin admin){
        if(service.updateById(admin)){
            return R.setOK();
        }
        return R.setERROR();
    }

    //退出登录
    @RequestMapping("/adminlogout.do")
    public R adminlogout(HttpServletRequest request){
        request.removeAttribute("admin");
        SecurityUtils.getSubject().getSession().removeAttribute("admin");

        return R.setOK();
    }

    //校验用户名
    @RequestMapping("/checkname.do")
    public R checkname(String name){
        return service.checkname(name);
    }

    //新增用户
    @RequestMapping("/saveadmin.do")
    public R saveadmin(Admin admin){
        if(service.saveAdmin(admin)){
            return R.setOK();
        }
        return R.setERROR();
    }
}
