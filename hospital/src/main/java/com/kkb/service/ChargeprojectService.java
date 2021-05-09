package com.kkb.service;

import com.kkb.bean.Behospital;
import com.kkb.bean.Chargeproject;

import java.util.List;

public interface ChargeprojectService {
    List<Chargeproject> selectAll();
    int insert(Chargeproject chargeproject);
    int update(Chargeproject chargeproject);
    int delete(int id);
    Chargeproject selectOne(Chargeproject chargeproject);
    /**
     * 查询数据库中全部信息的个数
     */
    int console();

    /**
     *     //查询数据库中所有的信息
     * @param
     * @return
     */
    List<Chargeproject> getChargeproject( int offset, int pageNumber);

    /**
     *   //通过名称来查询
     * @param id
     * @return
     */
    Chargeproject selectById(int id);

    /**
     *   //通过名称来查询
     * @param name
     * @return
     */
    Chargeproject selectByName(String name);
    /**
     * //通过名称来查询金额
     *
     * @param name
     * @return
     */

    String selectByName2(String name);

    /**
     *     //通过id值来删除对应的收费信息
     * @param id
     * @return
     */
    int deleteOne(Integer id);

}
