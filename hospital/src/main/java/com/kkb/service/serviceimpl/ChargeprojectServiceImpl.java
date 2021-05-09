package com.kkb.service.serviceimpl;

import com.kkb.bean.Behospital;
import com.kkb.bean.Chargeproject;
import com.kkb.dao.ChargeprojectMapper;
import com.kkb.service.ChargeprojectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChargeprojectServiceImpl implements ChargeprojectService {
    @Resource
    private ChargeprojectMapper mapper;
    /**
     * 查询数据库中全部信息的个数
     */
    @Override
    public int console() {
        return mapper.console();
    }

    @Override
    public List<Chargeproject> selectAll(){
        return mapper.selectAll();
    }
    /**
     * //查询数据库中所有的信息
     *
     * @param
     * @return
     */
    @Override
    public List<Chargeproject> getChargeproject(int offset, int pageNumber) {
        Map map = new HashMap();
        map.put("offset",offset);
        map.put("pageNumber",pageNumber);
        return mapper.getChargeproject(map);
    }

    /**
     * //通过id来查询
     *
     * @param id
     * @return
     */
    @Override
    public Chargeproject selectById(int id) {
        return mapper.selectById(id);
    }

    /**
     * 方法返回更新影响的条数
     *
     * @param chargeproject
     * @return
     */
    @Override
    public int update(Chargeproject chargeproject) {
        return mapper.updateByPrimaryKey(chargeproject);
    }


    /**
     * //通过名称来查询
     *
     * @param name
     * @return
     */
    @Override
    public Chargeproject selectByName(String name) {
        return mapper.selectByName(name);
    }

    /**
     * //通过名称来查询金额
     *
     * @param name
     * @return
     */
    @Override
    public String selectByName2(String name) {
        return mapper.selectByName2(name);
    }

    /**
     * //通过id值来删除对应的收费信息
     *
     * @param id
     * @return
     */
    @Override
    public int deleteOne(Integer id) {
        return mapper.deleteOne(id);
    }

    /**
     * 方法根据条件查询返回对应的Chargeproject
     *
     * @param chargeproject
     * @return
     */
    @Override
    public Chargeproject selectOne(Chargeproject chargeproject) {
        return mapper.selectOne(chargeproject);
    }


    /**
     * 方法返回插入影响的条数
     *
     * @param Chargeproject
     * @return
     */
    @Override
    public int insert(Chargeproject Chargeproject) {
        return mapper.insert(Chargeproject);
    }

    /**
     * 返回删除影响的条数
     *
     * @param rId
     * @return
     */
    @Override
    public int delete(int rId) {
        Chargeproject chargeproject = new Chargeproject();
        chargeproject.setChapId(rId);
        return mapper.delete(chargeproject);
    }
}
