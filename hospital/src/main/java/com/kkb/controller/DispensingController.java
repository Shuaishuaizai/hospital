package com.kkb.controller;

import com.kkb.bean.Drug;
import com.kkb.bean.Drugpeople;
import com.kkb.service.DrugPeopleService;
import com.kkb.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dispensing")
public class DispensingController {
    @Autowired
    private DrugPeopleService service;
    @Autowired
    private DrugService drugService;

    @RequestMapping("/index")
    public String index(Model model){
        List<Drugpeople> list = service.selectAll();
        model.addAttribute("list",list);
        return "hospital/dispensing";
    }

    @RequestMapping("/look/{peopleId}")
    public String look(@PathVariable("peopleId") Integer peopleId, Model model){
        Drugpeople drugpeople = new Drugpeople();
        drugpeople.setPeopleid(peopleId);
        drugpeople = service.selectOne(drugpeople);
        Drug drug = new Drug();
        drug.setDrId(drugpeople.getDrId());
        Drug d = drugService.selectOne(drug);
        model.addAttribute("dp",drugpeople);
        model.addAttribute("d",d);

        return "/hospital/dispensing-look";
    }

    @RequestMapping("/toGive/{peopleId}")
    public String toGive(@PathVariable("peopleId") Integer peopleId, Model model){
        Drugpeople drugpeople = new Drugpeople();
        drugpeople.setPeopleid(peopleId);
        drugpeople = service.selectOne(drugpeople);
        Drug drug = new Drug();
        drug.setDrId(drugpeople.getDrId());
        Drug d = drugService.selectOne(drug);
        model.addAttribute("dp",drugpeople);
        model.addAttribute("d",d);

        return "/hospital/dispensing-give";
    }

    @RequestMapping("/give/{peopleId}")
    public String give(@PathVariable("peopleId") Integer peopleId, Integer num, Model model){
        Drugpeople drugpeople = new Drugpeople();
        drugpeople.setPeopleid(peopleId);
        drugpeople = service.selectOne(drugpeople);
        drugpeople.setDrNumber(drugpeople.getDrNumber()-num);
        service.update(drugpeople);
        return index(model);
    }
}
