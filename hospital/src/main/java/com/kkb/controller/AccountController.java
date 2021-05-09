package com.kkb.controller;

import com.kkb.bean.Behospital;
import com.kkb.bean.Chargeproject;
import com.kkb.bean.Pricepeople;
import com.kkb.service.BehospitalService;
import com.kkb.service.ChargeprojectService;
import com.kkb.service.PricepeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private BehospitalService service;
    @Autowired
    private PricepeopleService service1;
    @Autowired
    private ChargeprojectService service2;

    @RequestMapping("/index")
    public String index(Model model){
        List<Behospital> list = service.selectAll();
        model.addAttribute("list",list);
        return "hospital/account";
    }

    @RequestMapping("/look/{behId}")
    public String look(@PathVariable("behId") Integer behId, Model model){
        Behospital behospital = new Behospital();
        behospital.setBehId(behId);
        behospital = service.selectOne(behospital);
        Pricepeople pp = new Pricepeople();
        pp.setBehId(behId);
        pp = service1.selectOne(pp);
        Chargeproject cp = new Chargeproject();
        cp.setChapId(pp.getChapId());
        Chargeproject chargeproject = service2.selectOne(cp);
        model.addAttribute("b",behospital);
        model.addAttribute("c",chargeproject);
        return "/hospital/account-look";
    }

}
