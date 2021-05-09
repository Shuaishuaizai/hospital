package com.kkb.service.serviceimpl;

import com.kkb.bean.Hosregister;
import com.kkb.bean.Menu;
import com.kkb.dao.HosregisterMapper;
import com.kkb.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author xiaoyou
 *
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    HosregisterMapper mapper;
    @Override
    public int insert(Hosregister record) {
        return mapper.insertSelective(record);
    }
//
//    @Override
//    public int insertSelective(Hosregister record) {
//        return 0;
//    }
//
//    @Override
//    public List<Menu> selectMenu(Integer rid) {
//        return null;
//    }

    @Override
    public int update(Hosregister hosregister){
        return mapper.update(hosregister);
    }
    @Override
    public List<Hosregister> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int delete(Hosregister hosregister) {
        return mapper.delete(hosregister);
    }

    /**
     * 方法查找对应的挂号信息
     *
     * @param hosregister
     * @return
     */
    @Override
    public Hosregister selectOne(Hosregister hosregister) {
        return mapper.selectOne(hosregister);
    }
}
