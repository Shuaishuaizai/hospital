package com.kkb.dao;

import com.kkb.bean.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoyou
 *
 */
public interface BehospitalMapper extends Mapper<Behospital> {
    //查询数据库中全部信息的个数
    int console();

    //查询数据库中所有的信息
    List<Behospital> getBehospital(Map map);

    //通过名称来查询
    Behospital selectByName(String name);

    //查询数据库中该id的信息
    List<BootStrapTableBC> getinfo(int bId, int cId);
    //通过id值来查询对应的收费信息
    Behospital selectById(Integer id);
    //通过名称和id来查询
    List<Behospital> selectByParams(Map map);
}