package com.kkb.service;

import com.kkb.bean.Behospital;
import com.kkb.bean.BootStrapTableBC;

import java.util.List;

public interface BehospitalService {

    List<Behospital> selectAll();
    int insert(Behospital behospital);
    int update(Behospital behospital);
    int delete(int id);
    Behospital selectOne(Behospital behospital);
    /**
     * 查询数据库中全部信息的个数
     */
    int console();

    List<Behospital> selectByParams(int id, String name);

    List<Behospital> getBeHospital( int offset, int pageNumber);

    /**
     *   //通过ID来查询
     * @param id
     * @return
     */
    Behospital selectById(int id);

    /**
     *   //通过名称来查询
     * @param name
     * @return
     */
    Behospital selectByName(String name);

    //查询数据库中该id的信息
    List<BootStrapTableBC> getinfo(int bId, int cId);

}
