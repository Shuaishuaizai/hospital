package com.kkb.controller;

import com.kkb.bean.Role;
import com.kkb.bean.User;
import com.kkb.service.RoleService;
import com.kkb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
/**
 * @author xiaoyou
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/login")
    public String login(){
        return "/login";
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "/login";
    }

    @GetMapping("/index")
    public String index(Model model){
        List<User> list = userService.selectAll();
        for (User user : list) {
            Role role1 = new Role();
            role1.setrId(user.getrId());
            Role role = roleService.selectByPrimaryKey(role1);
            user.setRole(role);
        }
        model.addAttribute("list",list);
        return "/User/index";
    }

    @GetMapping("/password")
    public String password(Model model,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("u");

        model.addAttribute("user",user);
        return "/User/password";
    }

    @PostMapping("/updatePass")
    public String updatePass(@RequestParam("uId") Integer uId,@RequestParam("nPass") String nPass,Model model){
        User u = new User();
        u.setuId(uId);
        User user = userService.selectOne(u);
        user.setuId(uId);
        user.setuPassword(nPass);
        int update = userService.update(user);
        if (update<=0){
            return "redirect:/user/password";
        }
        return "redirect:/user/logout";
    }

    @PostMapping("/select")
    public String select(User user,Model model){
        List<User> list =  new ArrayList<>();
        User user1 = userService.selectOne(user);
        Role role1 = new Role();
        role1.setrId(user1.getrId());
        Role role = roleService.selectByPrimaryKey(role1);
        user1.setRole(role);
        list.add(user1);
        model.addAttribute("list",list);
        return "/User/index";
    }

    @PostMapping("/check")
    public String check(User user, Model model, HttpServletRequest request){
        User u = userService.check(user);
        if (u!=null){
            request.getSession().setAttribute("u",u);
            model.addAttribute("u",u);
            return "/index";
        }
        return "/login";
    }

    @GetMapping("/toInsert")
    public String toInsert(Model model){
        List<Role> list = roleService.selectAll();
        model.addAttribute("list",list);
        return "User/addUser";
    }

    @PostMapping("/insert")
    public String insert(User user){
        int insert = userService.insert(user);
        if (insert<=0){
            return "redirect:/user/toInsert";
        }
        return "redirect:/user/index";
    }
    @GetMapping("/toUpdate/{uId}")
    public String toUpdate(@PathVariable("uId") Integer uId,Model model){
        User user = new User();
        user.setuId(uId);
        User user1 = userService.selectOne(user);
        model.addAttribute("u",user1);
        List<Role> list = roleService.selectAll();
        model.addAttribute("list",list);

        return "/User/editUser";
    }
    @PostMapping("/update")
    public String toUpdate(User user){
        int update = userService.update(user);
        if (update<=0){
            return "redirect:/user/toUpdate/"+user.getuId();
        }
        return "redirect:/user/index";
    }

    @DeleteMapping("/delete/{uId}")
    public String delete(@PathVariable("uId") Integer uId){
        User user = new User();
        user.setuId(uId);
        userService.delete(user);

        return "redirect:/user/index";
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(@RequestParam("uIds") String uIds){
        System.out.println(uIds);
        String[] temp = uIds.split(",");
        List<Integer> list =  new ArrayList<>();
        for (String s : temp) {
            list.add(Integer.parseInt(s));
        }
        userService.deleteAll(list);
        return "redirect:/user/index";
    }

}
