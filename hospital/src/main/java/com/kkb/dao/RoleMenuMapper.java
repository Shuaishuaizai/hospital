package com.kkb.dao;

import com.kkb.bean.RoleMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author xiaoyou
 *
 */
public interface RoleMenuMapper extends Mapper<RoleMenu> {

    /**
     * 方法返回通过rId查询到的mId集合
     * @param rId
     * @return
     */
    List<Integer> selectByrId(int rId);
}