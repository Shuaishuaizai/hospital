package com.kkb.service;

import com.kkb.bean.Role;
import com.kkb.bean.RoleMenu;

import java.util.List;

/**
 * @author xioayou
 * @date 2021/4/23
 * @time 22:31
 */
public interface RoleMenuService {

    /**
     * 方法返回插入影响的条数
     * @param roleMenu
     * @return
     */
    int insert(RoleMenu roleMenu);
    /**
     * 方法返回通过rId查询到的mId集合
     * @param rId
     * @return
     */
    List<Integer> selectByrId(int rId);

    /**
     * 返回删除影响的条数
     * @param rId
     * @return
     */
    int delete(int rId);
}
