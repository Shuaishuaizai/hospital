package com.kkb.dao;

import com.kkb.bean.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author xiaoyou
 *
 */
public interface MenuMapper extends Mapper<Menu> {
    /**
     * 方法根据给的角色id返回对应的菜单
     * @param rid
     * @return
     */
    List<Menu> selectMenu(Integer rid);
}