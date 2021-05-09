package com.kkb.service.serviceimpl;

import com.kkb.bean.User;
import com.kkb.dao.UserMapper;
import com.kkb.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author xiaoyou
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper mapper;

    @Override
    public User check(User user) {
        return mapper.check(user);
    }
    @Override
    public User selectOne(User user){
        return mapper.selectOne(user);
    }
    @Override
    public List<User> selectAll(){
        return mapper.selectAll();
    }
    @Override
    public int insert(User user){
        return mapper.insert(user);
    }
    @Override
    public int update(User user){
        return mapper.update(user);
    }
    @Override
    public int delete(User user){
        return mapper.delete(user);
    }

    @Override
    public int deleteAll(List<Integer> uIds) {
        return mapper.deleteAll(uIds);
    }

}
