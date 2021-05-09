package com.kkb.dao;

import com.kkb.bean.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author xiaoyou
 *
 */
public interface UserMapper extends Mapper<User> {
    /**
     * 根据条件查询对应的User
     * @param user
     * @return
     */
    User check(User user);

    /**
     * 方法返回更新影响的条数
     * @param user
     * @return
     */
    int update(User user);
    /**
     * 批量删除，方法返回更新影响的条数
     * @param uIds
     * @return
     */
    int deleteAll(List<Integer> uIds);

}