package com.edu.wlqz.mapper;

import com.edu.wlqz.pojo.Admin;
import com.edu.wlqz.vo.PageVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    int deleteById(Integer id);


    Admin selectByName(String name);

    PageVo selectByPage(@Param("page") Integer page, @Param("limit") Integer limit);

    List<Admin> selectAll();


    int updateById(Admin record);

    int saveAdmin(Admin admin);


}