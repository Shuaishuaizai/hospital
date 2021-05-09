package com.kkb.service;

import com.kkb.bean.Menu;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author xiaoyou
 *
 */
@Service
public interface MenuService {
    /**
     * 方法根据给的角色id返回对应的菜单
     * @param rid
     * @return
     */
    List<Menu> selectMenu(Integer rid);

    /**
     * 方法返回表中所有Menu
     * @return
     */
    List<Menu> selectAll();

    /**
     * 方法返回插入影响的条数
     * @return
     */
    int insert(Menu menu);

    /**
     * 方法返回根据mId查询的结果
     * @return
     */
    Menu selectOne(Menu menu);

    int update(Menu menu);

    int delete(Menu menu);
}
