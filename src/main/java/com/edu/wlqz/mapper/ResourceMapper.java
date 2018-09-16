package com.edu.wlqz.mapper;

import com.edu.wlqz.pojo.Resource;
import com.edu.wlqz.vo.PageVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceMapper {

    int deleteByRid(Integer id);

    int insert(Resource record);

    Resource selectByRid(Integer id);

    int updateByRid(Resource record);

    int selectcount();

    List<Resource> selectMenu(Integer uid);
    List<Resource> selectParentMenu(Integer uid);
    PageVo selectPageVo(@Param("page")Integer page,@Param("limit")Integer limit);
    List<String> selectByUid(Integer uid);
}