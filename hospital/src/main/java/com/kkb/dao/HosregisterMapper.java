package com.kkb.dao;

import com.kkb.bean.Hosregister;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author xiaoyou
 *
 */

public interface HosregisterMapper extends Mapper<Hosregister> {

    int update(Hosregister hosregister);
}