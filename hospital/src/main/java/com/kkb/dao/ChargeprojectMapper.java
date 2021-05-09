package com.kkb.dao;

import com.kkb.bean.Chargeproject;
import com.kkb.bean.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoyou
 */
public interface ChargeprojectMapper extends Mapper<Chargeproject> {
    //查询数据库中全部信息的个数
    int console();

    //查询数据库中所有的信息
    List<Chargeproject> getChargeproject(Map map);

    //通过名称来查询
    Chargeproject selectByName(String name);
    //通过名称来查询金额
    String selectByName2(String name);
    //通过id值来查询对应的收费信息
    Chargeproject selectById(Integer id);


    //通过id值来删除对应的收费信息
    int deleteOne(Integer id);

}