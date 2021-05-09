package com.kkb.service;

import com.kkb.bean.Doctor;

import java.util.List;

public interface DoctorService {
    /**
     * 查找所有的医生
     * @return 所有医生的列表
     */
    List<Doctor> selectAll();

    /**
     * 更新所选中的医生
     * @param doctor
     * @return 更新的数目
     */
    int update(Doctor doctor);

    /**
     * 插入医生
     * @param doctor
     * @return 插入的数量
     */
    int insert(Doctor doctor);

    /**
     * 根据id查找对应的医生
     * @param doctor
     * @return 查找出来的医生对象
     */
    Doctor selectOne(Doctor doctor);

    //查询所有的信息
    List<Doctor> getDoctors(int offset, int pageNumber);

    //查询数据库中的全部信息的个数
    int console();

    List<Doctor> selectByParams(int id, String name, String keshi);

}
