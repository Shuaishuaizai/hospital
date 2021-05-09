package com.kkb.controller;


import com.kkb.bean.Drug;
import com.kkb.service.DrugService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("drug")
public class DrugController {
    @Resource
    DrugService drugService;

    @RequestMapping("index")
    public String index(Model model) {
        List<Drug> list = drugService.selectAll();
        model.addAttribute("list", list);
        return "/Medicine/index";
    }

    @RequestMapping("/insert")
    public String insert(Drug drug) {
        return "/Medicine/add";
    }

    @RequestMapping("/toInsert")
    public String toInsert(Drug drug) {
        System.out.println(drug.getDrId());
        int i = drugService.insert(drug);
        System.out.println(i);
        if (i > 0) {
            return "redirect:/drug/index";
        } else {
            return "/Medicine/add";
        }
    }

    @RequestMapping("/updateNum")
    public String updateNum(@RequestParam("drNumber") int drNumber, @RequestParam("drId") int drId) {
        Drug drug = new Drug();
        drug.setDrId(drId);
        drug.setDrNumber(drNumber);
        drugService.updateNum(drug);
        return "/Medicine/index";
    }

    @RequestMapping("/toUpdateNum/{drId}")
    public String toUpdateNum(@PathVariable("drId") int drId, Model model) {
        Drug drug = new Drug();
        System.out.println(drug.getDrId());
        Drug tmp = drugService.selectOne(drug);
        model.addAttribute("d", tmp);
        return "/Medicine/add_medicine";
    }

    @RequestMapping("/register/look/{drId}")
    public String look(@PathVariable("drId") int drId, Model model) {
        Drug drug = new Drug();
        drug.setDrId(drId);
        Drug tmp = drugService.selectOne(drug);
        model.addAttribute("tmp", tmp);
        return "/Medicine/look";
    }
}
