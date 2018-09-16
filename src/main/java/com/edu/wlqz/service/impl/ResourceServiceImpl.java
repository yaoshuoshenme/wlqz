package com.edu.wlqz.service.impl;

import com.edu.wlqz.mapper.ResourceMapper;
import com.edu.wlqz.pojo.Resource;
import com.edu.wlqz.service.ResourceService;
import com.edu.wlqz.vo.MenuVo;
import commons.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper mapper;
    //删除
    @Override
    public R deleteByRid(Integer id) {
        return mapper.deleteByRid(id) > 0 ? R.setOK(): R.setERROR();
    }
    //新增
    @Override
    public R insert(Resource record) {
        return mapper.insert(record) > 0 ? R.setOK(): R.setERROR();
    }
    //查询
    @Override
    public R selectByRid(Integer id) {
        Resource resource = mapper.selectByRid(id);
        if(null != resource){
            return new R(0,"ok",resource);
        }
        return R.setERROR();
    }
    //修改
    @Override
    public R updateByRid(Resource record) {
        return mapper.updateByRid(record) > 0 ? R.setOK():R.setERROR();
    }
    //查询总资源数
    @Override
    public R selectcount() {
        return new R(0,"ok",mapper.selectcount());
    }
    //查询所有菜单资源
    @Override
    public R selectMenu(Integer uid) {
        List<Resource> resources = mapper.selectMenu(uid);
        if(null != resources){
            List<MenuVo> menuVos = new ArrayList<MenuVo>();
            for (Resource r : resources) {
                MenuVo menuVo = new MenuVo();
                if (r.getParentid() == -1) {
                    menuVo.setParent(r);
                    menuVo.setChildren(new ArrayList<>());
                    menuVos.add(menuVo);

                } else {
                    int index = r.getParentid().intValue();
                    for(MenuVo j : menuVos){
                        if(j.getParent().getId().intValue() == index){
                            j.getChildren().add(r);
                        }
                    }
                }
            }
            return new R(0,"ok",menuVos);
        }
        return R.setERROR();
    }
    //查询所有一级菜单
    @Override
    public R selectParentMenu(Integer uid) {
        List<Resource> resources = mapper.selectParentMenu(uid);
        if(null != resources){
            return new R(0,"ok",resources);
        }
        return R.setERROR();
    }
    //分页查询所有资源
    @Override
    public R selectPageVo(Integer page, Integer limit) {
        return new R(0,"ok",mapper.selectPageVo((page -1 )*limit,limit));
    }

    //查询用户拥有的所有资源
    @Override
    public R selectByUid(Integer uid) {
        List<String> resources = mapper.selectByUid(uid);
        if(null != resources && resources.size() > 0){
            return new R(0,"ok",resources);
        }
        return R.setERROR();
    }
}
