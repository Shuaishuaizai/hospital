package com.kkb.service.serviceimpl;

import com.kkb.bean.Menu;
import com.kkb.dao.MenuMapper;
import com.kkb.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author xiaoyou
 *
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectMenu(Integer rid) {
        return menuMapper.selectMenu(rid);
    }

    @Override
    public List<Menu> selectAll() {
        return menuMapper.selectAll();
    }

    @Override
    public int insert(Menu menu) {
        return menuMapper.insertSelective(menu);
    }

    @Override
    public Menu selectOne(Menu menu) {
        return menuMapper.selectOne(menu);
    }

    @Override
    public int update(Menu menu) {
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public int delete(Menu menu) {
        return menuMapper.delete(menu);
    }
}
