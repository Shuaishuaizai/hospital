package com.kkb.service.serviceimpl;

import com.kkb.bean.Pricepeople;
import com.kkb.dao.PricepeopleMapper;
import com.kkb.service.PricepeopleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PricepeopleServiceImpl implements PricepeopleService {
    @Resource
    private PricepeopleMapper mapper;
    @Override
    public List<Pricepeople> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int insert(Pricepeople pricepeople) {
        return mapper.insert(pricepeople);
    }

    @Override
    public int update(Pricepeople pricepeople) {
        return mapper.updateByPrimaryKey(pricepeople);
    }

    @Override
    public int delete(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Pricepeople selectOne(Pricepeople pricepeople) {
        return mapper.selectOne(pricepeople);
    }

    @Override
    public int insert1(int bid, int cid) {
        return mapper.insert1(bid,cid);
    }

    @Override
    public List<Integer> selectByID(int id) {
        return mapper.selectById(id);
    }
}
