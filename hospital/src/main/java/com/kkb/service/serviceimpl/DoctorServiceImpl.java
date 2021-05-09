package com.kkb.service.serviceimpl;

import com.kkb.bean.Doctor;
import com.kkb.dao.DoctorMapper;
import com.kkb.service.DoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Resource
    DoctorMapper mapper;
    /**
     * 查找所有的医生
     *
     * @return 所有医生的列表
     */
    @Override
    public List<Doctor> selectAll() {
        return mapper.selectAll();
    }

    /**
     * 更新所选中的医生
     *
     * @param doctor
     * @return 更新的数目
     */
    @Override
    public int update(Doctor doctor) {
        return mapper.update(doctor);
    }

    /**
     * 插入医生
     *
     * @param doctor
     * @return 插入的数量
     */
    @Override
    public int insert(Doctor doctor) {
        return mapper.insertSelective(doctor);
    }

    /**
     * 根据id查找对应的医生
     *
     * @param doctor
     * @return 查找出来的医生对象
     */
    @Override
    public Doctor selectOne(Doctor doctor) {
        return mapper.selectOne(doctor);
    }

    @Override
    public List<Doctor> getDoctors( int offset, int pageNumber) {
        Map map = new HashMap();
        map.put("offset",offset);
        map.put("pageNumber",pageNumber);
        return mapper.getDoctors(map);
    }

    @Override
    public int console() {
        return mapper.console();
    }

    @Override
    public List<Doctor> selectByParams(int id, String name, String keshi) {
        Map map = new HashMap();
        map.put("id",id);
        map.put("name",name);
        map.put("keshi",keshi);
        return mapper.selectByParams(map);
    }
}
