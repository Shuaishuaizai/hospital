package com.kkb.service;

import com.kkb.bean.Drugpeople;
import java.util.List;

public interface DrugPeopleService {
    List<Drugpeople> selectAll();
    int insert(Drugpeople drugpeople);
    int update(Drugpeople drugpeople);
    int delete(int id);
    Drugpeople selectOne(Drugpeople drugpeople);


}
