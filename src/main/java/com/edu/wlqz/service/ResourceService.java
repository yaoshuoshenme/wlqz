package com.edu.wlqz.service;

import com.edu.wlqz.pojo.Resource;
import com.edu.wlqz.vo.PageVo;
import commons.R;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceService {
    R deleteByRid(Integer id);

    R insert(Resource record);

    R selectByRid(Integer id);

    R updateByRid(Resource record);

    R selectcount();

    R selectMenu(Integer uid);
    R selectParentMenu(Integer uid);
    R selectPageVo(@Param("page")Integer page, @Param("limit")Integer limit);
    R selectByUid(Integer uid);
}
