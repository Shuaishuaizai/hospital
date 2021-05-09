package com.kkb.dao;

import com.kkb.bean.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoyou
 *
 */
public interface RoleMapper extends Mapper<Role> {

    int selectRId(Role role);


    List<Role> getRoles(Map map);
    //查询数据库中的全部信息的个数
    int console();
    int deleteAll(Integer[] ids);

    //通过名称来查询
    Role selectByName(String name);
}