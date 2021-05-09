package com.kkb.service.serviceimpl;

import com.kkb.bean.Behospital;
import com.kkb.bean.BootStrapTableBC;
import com.kkb.dao.BehospitalMapper;
import com.kkb.service.BehospitalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BehospitalServiceImpl implements BehospitalService {
    @Resource
    private BehospitalMapper mapper;

    /**
     * 查询数据库中全部信息的个数
     */
    @Override
    public int console() {
        return mapper.console();
    }

    @Override
    public List<Behospital> selectByParams(int id, String name) {
        Map map = new HashMap();
        map.put("id",id);
        map.put("name",name);
        return mapper.selectByParams(map);
    }

    /**
     * 方法返回表中所有的beHospital
     *
     * @return
     */
    @Override
    public List<Behospital> selectAll() {
        return mapper.selectAll();
    }

    /**
     * //查询数据库中所有的信息
     *
     * @param offset
     * @param pageNumber
     * @return
     */
    @Override
    public List<Behospital> getBeHospital(int offset, int pageNumber) {
        Map map = new HashMap();
        map.put("offset", offset);
        map.put("pageNumber", pageNumber);
        return mapper.getBehospital(map);

    }

    /**
     * //通过名称来查询
     *
     * @param id
     * @return
     */
    @Override
    public Behospital selectById(int id) {
        return mapper.selectById(id);
    }

    /**
     * 方法返回更新影响的条数
     *
     * @param behospital
     * @return
     */
    @Override
    public int update(Behospital behospital) {
        return 0;
    }

    /**
     * //通过名称来查询
     *
     * @param name
     * @return
     */
    @Override
    public Behospital selectByName(String name) {
        return mapper.selectByName(name);
    }


    /**
     * 方法根据条件查询返回对应的Behospital
     *
     * @param Behospital@return
     */
    @Override
    public Behospital selectOne(Behospital Behospital) {
        return mapper.selectOne(Behospital);
    }

    @Override
    public List<BootStrapTableBC> getinfo(int bId, int cId) {
        return mapper.getinfo(bId,cId);
    }

    /**
     * 方法返回插入影响的条数
     *
     * @param Behospital@return
     */
    @Override
    public int insert(Behospital Behospital) {
        return mapper.insert(Behospital);
    }

    /**
     * 返回删除影响的条数
     *
     * @param rId
     * @return
     */
    @Override
    public int delete(int rId) {
        return 0;
    }

}
