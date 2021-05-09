package com.kkb.service;

import com.kkb.bean.User;

import java.util.List;
/**
 * @author xiaoyou
 *
 */
public interface UserService {

    /**
     * 根据条件查询对应的User
     * @param user
     * @return
     */
    User check(User user);

    /**
     * 方法返回表中所有的User
     * @return
     */
    List<User> selectAll();

    /**
     * 方法根据条件查询对应的User
     * @param user
     * @return
     */
    User selectOne(User user);

    /**
     * 方法返回插入影响的条数
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 方法返回更新影响的条数
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 方法返回删除影响的条数
     * @param user
     * @return
     */
    int delete(User user);
    int deleteAll(List<Integer> uIds);
}
