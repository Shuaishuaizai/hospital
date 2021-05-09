package com.kkb.service.serviceimpl;

import com.kkb.bean.Role;
import com.kkb.dao.RoleMapper;
import com.kkb.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoyou
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper mapper;

    @Override
    public Role selectByPrimaryKey(Role role) {

        return mapper.selectOne(role);
    }
    @Override
    public List<Role> selectAll(){
        return mapper.selectAll();
    }

    @Override
    public Role selectOne(Role role) {
        return mapper.selectOne(role);
    }

    @Override
    public int insert(Role role) {
        return mapper.insertSelective(role);
    }

    @Override
    public int selectRId(Role role) {
        return mapper.selectRId(role);
    }

    @Override
    public int update(Role role) {
        return mapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int delete(Role role) {
        return mapper.delete(role);
    }

    @Override
    public List<Role> getRoles( int offset, int pageNumber) {
        Map map = new HashMap();
        map.put("offset",offset);
        map.put("pageNumber",pageNumber);
        return mapper.getRoles(map);
    }

    @Override
    public int console() {
        return mapper.console();
    }

    @Override
    @Transactional
    public int deleteAll(Integer[] ids) {
        return mapper.deleteAll(ids);
    }

    @Override
    public Role selectByName(String name) {
        return mapper.selectByName(name);
    }

}
