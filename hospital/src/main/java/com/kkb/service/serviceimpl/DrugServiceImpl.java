package com.kkb.service.serviceimpl;

import com.kkb.bean.Drug;
import com.kkb.dao.DrugMapper;
import com.kkb.service.DrugService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {
    @Resource
    DrugMapper mapper;
    /**
     * 查找所有的药品
     *
     * @return 药品的列表
     */
    @Override
    public List<Drug> selectAll() {
        return mapper.selectAll();
    }

    /**
     * 更新传入的药品
     *
     * @param drug
     * @return 更新的数目
     */
    @Override
    public int update(Drug drug) {
        return 0;
    }

    /**
     * 根据传入的药品查找对应的药品
     *
     * @param drug
     * @return 查找出来的药品
     */
    @Override
    public Drug selectOne(Drug drug) {
        return mapper.selectOne(drug);
    }

    /**
     * 插入新的药品
     *
     * @param drug
     * @return 返回插入的数目
     */
    @Override
    public int insert(Drug drug) {
        return mapper.insert(drug);
    }

    /**
     * 更新药品的库存数量
     *
     * @param drug
     * @return 返回更新的数目
     */
    @Override
    public int updateNum(Drug drug) {
        return mapper.updateNum(drug);
    }
}
