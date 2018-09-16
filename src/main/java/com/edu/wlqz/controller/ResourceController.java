package com.edu.wlqz.controller;

import com.edu.wlqz.pojo.Resource;
import com.edu.wlqz.service.ResourceService;
import commons.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
    @Autowired
    private ResourceService service;

    //增
    @RequestMapping("/saveresource.do")
    public R saveResource(Resource resource){
        return service.insert(resource);
    }
    //删
    @RequestMapping("/delresource.do")
    public R delResource(Integer rid){
        return service.deleteByRid(rid);
    }

    //查
    @RequestMapping("queryresource.do")
    public R queryResource(Integer rid){
        return service.selectByRid(rid);
    }
    //查资源总数
    @RequestMapping("queryresourcecount.do")
    public R queryResourceCount(){
        return service.selectcount();
    }
    //查用户所有资源
    @RequestMapping("/queryresourcebyuid.do")
    public  R queryResourceByUid(Integer uid){
        return service.selectMenu(uid);
    }
    //查一级菜单
    @RequestMapping("/queryparentresource.do")
    public R queryParentResource(Integer uid){
        return service.selectParentMenu(uid);
    }
    //查所有权限
    @RequestMapping("/queryallresourcebyuid.do")
    public R queryAllResourceByUid(Integer uid){
        return service.selectByUid(uid);
    }
    //分页查资源列表
    @RequestMapping("/queryresourcebypage.do")
    public R queryResourceByPage(Integer page, Integer limit){
        return service.selectPageVo(page,limit);
    }
}
