package com.kkb.controller;

import com.kkb.bean.*;
import com.kkb.service.ChargeprojectService;

import com.kkb.util.DataRe;
import com.kkb.util.ResultData;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("charge")
public class ChargeprojectController {
    @Resource
    private ChargeprojectService chargeprojectService;

    /**
     * 动态查找数据库中的所有信息
     *
     * @param offset
     * @param pageNumber
     * @return
     */
    @RequestMapping("getAllCharge")
    @ResponseBody
    public DataRe list(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                       @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
        //通过分页查询得到数据
        List<Chargeproject> chargeproject = chargeprojectService.getChargeproject(offset, pageNumber);
        List<BootStrapTableChargeproject> list = new ArrayList<>();
        for (Chargeproject chargeproject1 : chargeproject) {
            String name = chargeproject1.getChapName() == "" ? "暂无名字" : chargeproject1.getChapName();
            String money = chargeproject1.getChapMoney().toString() == "" ? "暂无价格" : chargeproject1.getChapMoney().toString();
            BootStrapTableChargeproject chargeproject2 = new BootStrapTableChargeproject(chargeproject1.getChapId(), name, money);
            list.add(chargeproject2);
        }
        //2. 将集合封装为 bootstrap-table识别的格式
        //查询总条数
        int total = chargeprojectService.console();
        ResultData<BootStrapTableChargeproject> data = new ResultData<>();
        data.setRows(list);
        data.setTotal(total);
        DataRe dataRe = new DataRe();
        dataRe.setData(data);
        return dataRe;

    }

    /**
     * 添加收费信息
     *
     * @param chargeproject
     * @return
     */
    @RequestMapping("insert")
    @Transactional(rollbackFor = Exception.class)
    public String insert(Chargeproject chargeproject) {
        int insert = chargeprojectService.insert(chargeproject);
        if (insert <= 0) {
            return "redirect:/charge/toInsert";
        }
        return "redirect:/charge/index";
    }

    /**
     * 更新信息
     *
     * @param chargeproject
     * @return
     */
    @RequestMapping("update")
    @Transactional(rollbackFor = Exception.class)
    public String update(Chargeproject chargeproject) {
        //更新 id值不能动
        chargeprojectService.update(chargeproject);

        return "redirect:/charge/index";
    }

    @RequestMapping("/toUpdate/{chapId}")
    public String toUpdate(@PathVariable("chapId") Integer chapId, Model model) {
        Chargeproject chargeproject = new Chargeproject();
        chargeproject.setChapId(chapId);
        Chargeproject chargeproject1 = chargeprojectService.selectOne(chargeproject);
        model.addAttribute("c", chargeproject1);
        return "/hospital/charge-edit2";


    }

    /**
     * 删除
     *
     * @param chapId
     * @return
     */
    @RequestMapping("delete/{chapId}")
    @Transactional(rollbackFor = Exception.class)
    public String delete(@PathVariable("chapId") Integer chapId) {
        //把查询的信息删掉
        chargeprojectService.delete(chapId);
        return "redirect:/charge/index";
    }

    /**
     * 查询
     *
     * @param chargeproject
     * @param model
     * @return
     */
    @RequestMapping("select")
    public String select(Chargeproject chargeproject, Model model) {
        List<Chargeproject> list = new ArrayList<>();
        Chargeproject chargeproject1 = chargeprojectService.selectOne(chargeproject);
        list.add(chargeproject1);
        model.addAttribute("list", list);
        return "redirect:/charge/index";
    }

    /**
     * 跳转到增加页面
     *
     * @param
     * @return
     */
    @RequestMapping("toInsert")
    public String toInsert() {
        return "/hospital/charge-edit1";
    }

    /**
     * 跳转页面
     *
     * @param model
     * @return
     */
    @RequestMapping("index")
    public String index(Model model) {
        List<Chargeproject> list = chargeprojectService.selectAll();
        model.addAttribute("list", list);
        return "/hospital/charge";
    }

    /**
     * 动态查询编号是否唯一
     */
    @RequestMapping("getId")
    @ResponseBody
    public DataRe getName(@RequestParam(value = "chargeId", defaultValue = "") int chargeId) {
        //通过id获取数据库中的相应的收费信息

        Chargeproject chargeproject = chargeprojectService.selectById(chargeId);
        DataRe dataRe = new DataRe();
        if (chargeproject != null) {
            //有对应的对象
            dataRe.setStatus(-1);
        } else {
            //没有对应的对象
            dataRe.setStatus(0);
        }
        return dataRe;
    }

    /**
     * 模糊查询
     *
     * @param req
     * @return
     */
    @RequestMapping("findByParams")
    @ResponseBody
    public DataRe findByParams(HttpServletRequest req) {
        String name = req.getParameter("name");
        List<Chargeproject> charges = new ArrayList<>();
        if (!(name.isEmpty() || name == null)) {
            charges.add(chargeprojectService.selectByName(name));
        }
        List<BootStrapTableChargeproject> chargeList = new ArrayList<>();
        for (Chargeproject c : charges) {
            chargeList.add(new BootStrapTableChargeproject(c));
        }

        int total = chargeprojectService.console();
        ResultData<BootStrapTableChargeproject> data = new ResultData<>();
        data.setTotal(total);
        data.setRows(chargeList);
        DataRe dataRe = new DataRe();
        dataRe.setData(data);
        return dataRe;
    }

}
