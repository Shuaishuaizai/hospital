package com.kkb.controller;


import com.kkb.bean.Hosregister;
import com.kkb.dao.HosregisterMapper;
import com.kkb.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/**
 * @author xiaoyou
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Resource
    private RegisterService registerService;


    @RequestMapping("/index")
    public String selectAll(Model model){
        List<Hosregister> list = registerService.selectAll();
        model.addAttribute("list",list);
        return "/registration/index";
    }
    @RequestMapping("/add")
    public String add(){
        return "/registration/add";
    }

    @RequestMapping("/insert")
    public String insert(Hosregister hosregister){
        int i = registerService.insert(hosregister);
        if(i > 0){
            return "redirect:/register/index";
        }
        System.out.println("插入失败");
        return "redirect:/register/index";
    }
    @RequestMapping("/delete")
    public String delete(int [] ids){
        for (int id:
                ids) {
            Hosregister hosregister = new Hosregister();
            hosregister.setHosrId(id);
            registerService.delete(hosregister);
        }
        return "redirect:/register/index";
    }


    @RequestMapping("/deleteById/{hosrId}")
    public String deleteById(@PathVariable("hosrId") int hosrId){
        Hosregister hosregister = new Hosregister();
        hosregister.setHosrId(hosrId);
        registerService.delete(hosregister);
        return  "redirect:/register/index";
    }

    @RequestMapping("/update/{hosrId}")
    public String update(@PathVariable("hosrId") int hosrId,Model model){
        int tmpHosrId = hosrId;
        model.addAttribute("tmpHosId",tmpHosrId);
        return "/registration/edit";
    }
    @RequestMapping("/toUpdate")
    public String toUpdate(Hosregister hosregister){
        registerService.update(hosregister);
        return "redirect:/register/index";
    }

    @RequestMapping("/look/{hosrId}")
    public String look(Model model,@PathVariable("hosrId") int hosrId){
        Hosregister hosregister = new Hosregister();
        hosregister.setHosrId(hosrId);
        System.out.println(hosrId);
        Hosregister tmp = registerService.selectOne(hosregister);
        model.addAttribute("tmp",tmp);
        System.out.println(tmp);
        return "/registration/look";
    }
}
