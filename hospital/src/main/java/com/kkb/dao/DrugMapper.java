package com.kkb.dao;

import com.kkb.bean.Drug;
import tk.mybatis.mapper.common.Mapper;
/**
 * @author xiaoyou
 *
 */
public interface DrugMapper extends Mapper<Drug> {
    int updateNum(Drug drug);
}