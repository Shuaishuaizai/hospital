package com.kkb.service.serviceimpl;

import com.kkb.bean.Drug;
import com.kkb.bean.User;
import com.kkb.service.DrugService;
import com.kkb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService service;

}