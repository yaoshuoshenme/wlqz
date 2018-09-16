package com.edu.wlqz.controller;

import commons.R;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShiroPerController {
    @RequestMapping("/shiropercheck.do")
    public R shiropercheck(String per){
        try{
            SecurityUtils.getSubject().checkPermission(per);
            return R.setOK();
        }catch (Exception e){
            return  R.setERROR();
        }
    }
}
