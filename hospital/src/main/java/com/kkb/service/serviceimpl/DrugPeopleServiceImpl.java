package com.kkb.service.serviceimpl;

import com.kkb.bean.Drugpeople;
import com.kkb.dao.DrugpeopleMapper;
import com.kkb.service.DrugPeopleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DrugPeopleServiceImpl implements DrugPeopleService {
    @Resource
    private DrugpeopleMapper mapper;
    @Override
    public List<Drugpeople> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int insert(Drugpeople drugpeople) {
        return mapper.insert(drugpeople);
    }

    @Override
    public int update(Drugpeople drugpeople) {
        return mapper.updateByPrimaryKey(drugpeople);
    }

    @Override
    public int delete(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Drugpeople selectOne(Drugpeople drugpeople) {
        return mapper.selectOne(drugpeople);
    }
}
