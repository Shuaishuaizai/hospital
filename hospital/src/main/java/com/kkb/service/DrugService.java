package com.kkb.service;


import com.kkb.bean.Drug;

import java.util.List;

public interface DrugService {
    /**
     * 查找所有的药品
     * @return 药品的列表
     */
    List<Drug> selectAll();

    /**
     * 更新传入的药品
     * @param drug
     * @return 更新的数目
     */
    int update(Drug drug);

    /**
     * 根据传入的药品查找对应的药品
     * @param drug
     * @return 查找出来的药品
     */
    Drug selectOne(Drug drug);

    /**
     * 插入新的药品
     * @param drug
     * @return 返回插入的数目
     */
    int insert(Drug drug);

    /**
     * 更新药品的库存数量
     * @param drug
     * @return 返回更新的数目
     */
    int updateNum(Drug drug);
}
