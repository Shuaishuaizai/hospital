package com.kkb.service;

import com.kkb.bean.Role;

import java.util.List;
/**
 * @author xiaoyou
 *
 */
public interface RoleService {

    /**
     * 根据主键查询对应的Role
     * @param role
     * @return
     */
    Role selectByPrimaryKey(Role role);

    /**
     * 方法返回表中所有的Role
     * @return
     */
    List<Role> selectAll();

    /**
     * 方法根据条件查询返回对应的Role
     * @param role
     * @return
     */
    Role selectOne(Role role);

    /**
     * 方法返回插入影响的条数
     * @param role
     * @return
     */
    int insert(Role role);

    /**
     * 方法功能是根据rName查询其rId，返回值为rId
     * @param role
     * @return
     */
    int selectRId(Role role);

    /**
     * 方法返回更新影响的条数
     * @return
     */
    int update(Role role);

    /**
     * 方法返回删除影响的条数
     * @param role
     * @return
     */
    int delete(Role role);

    //查询所有的信息
    List<Role> getRoles( int offset, int pageNumber);

    //查询数据库中的全部信息的个数
    int console();

    //批量删除
    int deleteAll(Integer[] ids);

    Role selectByName(String name);

}
