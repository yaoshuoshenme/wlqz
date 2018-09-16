package com.edu.wlqz.mapper;

import com.edu.wlqz.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    int deleteById(Integer id);

    int insert(Role role);


    List<Role> selectAll();


}