package com.kkb.controller;

import com.kkb.bean.*;
import com.kkb.service.MenuService;
import com.kkb.service.RoleMenuService;
import com.kkb.service.RoleService;
import com.kkb.util.DataRe;
import com.kkb.util.ResultData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/**
 * @author xiaoyou
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;
    @Resource
    private MenuService menuService;
    @Resource
    private RoleMenuService roleMenuService;


    @RequestMapping("/getAllRoles")
    @ResponseBody
    public DataRe list(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                       @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
        //通过分页查询得到数据
        List<Role> roles = roleService.getRoles(offset, pageNumber);
        List<BootStrapTableRole> list = new ArrayList<>();
        for (Role role : roles) {
            String state = role.getrState() == 0 ? "正常" : "禁用";
            BootStrapTableRole r2 = new BootStrapTableRole(role.getrId(), role.getrName(), state);
            list.add(r2);
        }

        //2. 将集合封装为 bootstrap-table识别的格式
        //查询总条数
        int total = roleService.console();
        ResultData<BootStrapTableRole> data = new ResultData<>();
        data.setRows(list);
        data.setTotal(total);
        DataRe dataRe = new DataRe();
        dataRe.setData(data);
        return dataRe;
    }

    @RequestMapping("/index")
    public String index(Model model){
        List<Role> list = roleService.selectAll();
        model.addAttribute("list",list);
        return "/Role/index";
    }

    @RequestMapping("/select")
    public String select(Role role,Model model){
        Role role1 = roleService.selectOne(role);
        List<Role> list =new ArrayList<>();
        list.add(role1);
        model.addAttribute("list",list);
         return "/Role/index";
    }

    @RequestMapping("/toInsert")
    public String toInsert(Model model){
        List<Menu> list = menuService.selectAll();
        model.addAttribute("list",list);
        return "/Role/addRole";
    }

    @RequestMapping("/insert")
    @Transactional(rollbackFor = Exception.class)
    public String insert(Role role){
        int insert = roleService.insert(role);
        int rId = roleService.selectRId(role);
        int[] mIds = role.getmIds();
        boolean flag = true;
        for (int mId : mIds) {
            int insert1 = roleMenuService.insert(new RoleMenu(rId, mId));
            if (insert1<=0){
                flag=false;
            }
        }
        if (insert<=0 && flag){
            return "redirect:/role/toInsert";
        }
        return "redirect:/role/index";
    }

    @RequestMapping("/toUpdate/{rId}")
    public String toUpdate(@PathVariable("rId") Integer rId, Model model){
        Role role = new Role();
        role.setrId(rId);
        Role role1 = roleService.selectOne(role);
        model.addAttribute("r",role1);
        List<Menu> list = menuService.selectAll();
        model.addAttribute("list",list);
        ArrayList<Integer> list2 = (ArrayList<Integer>) roleMenuService.selectByrId(rId);
        List<Menu> list1 = menuService.selectAll();
        for (Integer integer : list2) {
            Menu menu = new Menu();
            menu.setmId(integer);
            list1.add(menu);
        }
        model.addAttribute("list1",list1);
        return "/Role/editRole";
    }
    @RequestMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public String update(Role role){
        int insert = roleService.update(role);
        int[] mIds = role.getmIds();
        boolean flag = true;
        int delete = roleMenuService.delete(role.getrId());
        if (delete>0){
            for (int mId : mIds) {
                int insert1 = roleMenuService.insert(new RoleMenu(role.getrId(), mId));
                if (insert1<=0){
                    flag=false;
                }
            }
            if (insert<=0 && flag){
                return "redirect:/role/toUpdate/"+role.getrId();
            }
        }
        return "redirect:/role/index";
    }
    @RequestMapping("/delete/{rId}")
    @Transactional(rollbackFor = Exception.class)
    public String delete(@PathVariable("rId") Integer rId){
        Role role = new Role();
        role.setrId(rId);
        roleService.delete(role);
        roleMenuService.delete(rId);
        return "redirect:/role/index";
    }

    @RequestMapping("delAllRoles")
    @ResponseBody
    public DataRe list(@Param("ids") String ids) {
        String[] split = ids.split(",");
        Integer [] id = new  Integer [split.length];
        for (int i = 0; i < split.length; i++) {
            id[i] = Integer.parseInt(split[i]);
        }
        //受影响的行数
        int count = roleService.deleteAll(id);
        DataRe dataRe = new DataRe();
        if (count > 0) {
            dataRe.setMsg("删除成功!");
            dataRe.setStatus(0);
        } else {
            dataRe.setMsg("删除失败!");
            dataRe.setStatus(1);
        }
        return dataRe;
    }

    /**
     * 动态查询名字是否唯一
     *
     */
    @RequestMapping("getName")
    @ResponseBody
    public DataRe getName(@RequestParam(value = "roleName", defaultValue = "") String roleName){
        //通过sql获取数据库中的
        Role role = roleService.selectByName(roleName);
        DataRe dataRe = new DataRe();
        if (role!=null){
            //有对应的对象
            dataRe.setStatus(-1);
        }else {
            //没有对应的对象
            dataRe.setStatus(0);
        }
        return dataRe;
    }
}
