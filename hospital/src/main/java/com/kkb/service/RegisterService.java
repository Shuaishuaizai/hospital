package com.kkb.service;

import com.kkb.bean.Hosregister;
import com.kkb.bean.Menu;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author xiaoyou
 *
 */
public interface RegisterService {

    /**
     * 方法返回执行挂号信息插入操作
     * @param record
     * @return
     */
    int insert(Hosregister record);

    /**
     * 方法返回表中所有的Hosregister
     * @return
     */
    List<Hosregister> selectAll();

    /**
     * 方法删除对应的挂号信息
     * @param hosregister
     * @return 是否删除成功
     */
    int delete(Hosregister hosregister);

    /**
     * 方法更新对应的挂号信息
     * @param hosregister
     * @return 是否更新成功
     */
    int update(Hosregister hosregister);

    /**
     * 方法查找对应的挂号信息
     * @param hosregister
     * @return
     */
    Hosregister selectOne(Hosregister hosregister);
}
