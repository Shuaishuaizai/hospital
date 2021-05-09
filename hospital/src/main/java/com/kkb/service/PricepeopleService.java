package com.kkb.service;

import com.kkb.bean.Behospital;
import com.kkb.bean.Pricepeople;

import java.util.List;

public interface PricepeopleService {
    List<Pricepeople> selectAll();
    int insert(Pricepeople pricepeople);
    int update(Pricepeople pricepeople);
    int delete(int id);
    Pricepeople selectOne(Pricepeople pricepeople);
    //通过id查询 收费信息的ID
    List<Integer> selectByID(int id);
    int insert1(int bid,int cid);
}
