package com.kkb.dao;

import com.kkb.bean.Doctor;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoyou
 *
 */
public interface DoctorMapper extends Mapper<Doctor> {
    int update(Doctor doctor);
    List<Doctor> getDoctors(Map map);
    List<Doctor> selectByParams(Map map);
    //查询数据库中的全部信息的个数
    int console();
}