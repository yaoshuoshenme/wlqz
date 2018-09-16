package com.edu.wlqz.service.impl;

import com.edu.wlqz.mapper.AdminMapper;
import com.edu.wlqz.pojo.Admin;
import com.edu.wlqz.service.AdminService;
import com.edu.wlqz.vo.PageVo;
import commons.EncrypUtil;
import commons.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper mapper;

    @Override
    public boolean deleteById(Integer id) {
        return mapper.deleteById(id) > 0;
    }

    @Override
    public Admin selectByName(String name, String password) {
        String md5password = EncrypUtil.md5Pass(password);
        Admin admin = mapper.selectByName(name);
        if(admin != null && Objects.equals(md5password,admin.getPassword())){
            return admin;
        }
        return null;
    }

    @Override
    public PageVo selectByPage(Integer page, Integer limit) {
        return mapper.selectByPage((page - 1)*limit,limit);
    }

    @Override
    public List<Admin> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public boolean updateById(Admin record) {
        return mapper.updateById(record) > 0;
    }

    @Override
    public R checkname(String name) {
        if(mapper.selectByName(name) != null){
            return R.setERROR();
        }
        return R.setOK();
    }

    @Override
    public boolean saveAdmin(Admin admin) {
        String password = admin.getPassword();
        String md5password = EncrypUtil.md5Pass(password);
        admin.setPassword(md5password);
        return mapper.saveAdmin(admin) > 0;
    }
}
