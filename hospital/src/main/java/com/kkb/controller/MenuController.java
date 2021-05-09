package com.kkb.controller;

import com.kkb.bean.Menu;
import com.kkb.bean.Role;
import com.kkb.bean.RoleMenu;
import com.kkb.bean.User;
import com.kkb.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyou
 * @date 2021/4/24
 * @time 11:53
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;


    @RequestMapping("/index")
    public String index(Model model){
        List<Menu> list = menuService.selectAll();
        model.addAttribute("list",list);
        return "/Resource/index";
    }

    @RequestMapping("/toInsert")
    public String toInsert(){
        return "/Resource/add";
    }

    @RequestMapping("/insert")
    public String insert(Menu menu){
        int insert = menuService.insert(menu);
        if (insert<=0){
            return "redirect:/menu/toInsert";
        }
        return "redirect:/menu/index";
    }

    @RequestMapping("/toUpdate/{mId}")
    public String toUpdate(@PathVariable("mId") Integer mId,Model model){
        Menu menu = new Menu();
        menu.setmId(mId);
        Menu menu1 = menuService.selectOne(menu);
        model.addAttribute("m",menu1);
        return "/Resource/edit";
    }
    @RequestMapping("/update")
    public String update(Menu menu,Model model){
        int update = menuService.update(menu);
        if (update<=0){
            return "redirect:/menu/toUpdate/"+menu.getmId();
        }
        return "redirect:/menu/index";
    }

    @RequestMapping("/delete/{mId}")
    public String delete(@PathVariable("mId") Integer mId){
        Menu menu = new Menu();
        menu.setmId(mId);
        menuService.delete(menu);
        return "redirect:/menu/index";
    }
}
