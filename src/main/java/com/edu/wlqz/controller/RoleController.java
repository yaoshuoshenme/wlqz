package com.edu.wlqz.controller;

import com.edu.wlqz.pojo.Role;
import com.edu.wlqz.service.RoleService;
import commons.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService service;

    //新增
    @RequestMapping("/saverole.do")
    public R saverole(Role role){
        return service.insert(role);
    }

    //查询
    @RequestMapping("/queryallrole.do")
    public R queryallrole(Integer rid){
        return service.selectAll();
    }

    //删除
    @RequestMapping("/delrole.do")
    public R delrole(Integer rid){
        return service.deleteById(rid);
    }
}
