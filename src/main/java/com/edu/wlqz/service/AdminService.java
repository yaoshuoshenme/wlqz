package com.edu.wlqz.service;

import com.edu.wlqz.pojo.Admin;
import com.edu.wlqz.vo.PageVo;
import commons.R;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {

    boolean deleteById(Integer id);


    Admin selectByName(String name, String password);

    PageVo selectByPage(@Param("page") Integer page, @Param("limit") Integer limit);

    List<Admin> selectAll();


    boolean updateById(Admin record);

    R checkname(String name);

    boolean saveAdmin(Admin admin);
}
