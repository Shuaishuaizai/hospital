package com.kkb.dao;


import com.kkb.bean.Pricepeople;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author xiaoyou
 *
 */
public interface PricepeopleMapper extends Mapper<Pricepeople> {
    /**
     * //获取到 id 进行添加
     * @param
     * @return
     */
    int insert1(int bid,int cid);
    List<Integer> selectById(int bid);
}