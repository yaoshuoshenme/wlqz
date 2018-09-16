package com.edu.wlqz.service;

import com.edu.wlqz.pojo.Role;
import commons.R;

import java.util.List;

public interface RoleService {

    R deleteById(Integer id);

    R insert(Role role);


    R selectAll();
}
