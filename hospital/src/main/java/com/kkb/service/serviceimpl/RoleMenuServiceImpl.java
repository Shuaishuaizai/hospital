package com.kkb.service.serviceimpl;

import com.kkb.bean.RoleMenu;
import com.kkb.dao.RoleMenuMapper;
import com.kkb.service.RoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaoyou
 * @date 2021/4/23
 * @time 22:33
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Resource
    private RoleMenuMapper roleMenuMapper;


    @Override
    public int insert(RoleMenu roleMenu) {
        return roleMenuMapper.insertSelective(roleMenu);
    }

    @Override
    public List<Integer> selectByrId(int rId) {
        return roleMenuMapper.selectByrId(rId);
    }

    @Override
    public int delete(int rId) {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setrId(rId);
        return roleMenuMapper.delete(roleMenu);
    }
}
