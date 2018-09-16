package com.edu.wlqz.service.impl;

import com.edu.wlqz.mapper.RoleMapper;
import com.edu.wlqz.pojo.Role;
import com.edu.wlqz.service.RoleService;
import commons.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper mapper;
    //删除
    @Override
    public R deleteById(Integer id) {
        return mapper.deleteById(id) > 0 ? R.setOK(): R.setERROR();
    }
    //新增
    @Override
    public R insert(Role role) {
        return mapper.insert(role) > 0 ? R.setOK(): R.setERROR();
    }
    //查询所有
    @Override
    public R selectAll() {
        List<Role> roles = mapper.selectAll();
        if(null != roles){
            return new R(0,"ok",roles);
        }
        return R.setERROR();
    }
}
