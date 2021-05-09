package com.kkb.controller;

import com.kkb.bean.Behospital;
import com.kkb.service.BehospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hospital")
public class BehostptalController {
    @Autowired
    private BehospitalService service;

    @RequestMapping("/index")
    public String index(Model model){
        List<Behospital> list = service.selectAll();
        model.addAttribute("list",list);
        return "hospital/index";
    }

    @RequestMapping("/toInsert")
    public String toInsert(){
        return "hospital/add";
    }

    @RequestMapping("/insert")
    public String insert(Behospital behospital){
        behospital.setBehState(0);
        service.insert(behospital);
        return "/hospital/index";
    }

    @RequestMapping("/delete")
    public String delete(int behId){
        service.delete(behId);
        return "/hospital/index";
    }

    @RequestMapping("/toUpdate/{behId}")
    public String toUpdate(@PathVariable("behId") Integer behId, Model model){
        Behospital behospital = new Behospital();
        behospital.setBehId(behId);
        behospital = service.selectOne(behospital);
        model.addAttribute("b",behospital);
        return "/hospital/edit";
    }

    @RequestMapping("/look/{behId}")
    public String look(@PathVariable("behId") Integer behId, Model model){
        Behospital behospital = new Behospital();
        behospital.setBehId(behId);
        behospital = service.selectOne(behospital);
        model.addAttribute("b",behospital);
        return "/hospital/look";
    }

    @RequestMapping("/update")
    public String update(Behospital behospital){
        int i = service.update(behospital);
        if(i > 0){
            return "redirect:/hospital/index";
        }
        else{
            return "/hospital/edit";
        }
    }
}
