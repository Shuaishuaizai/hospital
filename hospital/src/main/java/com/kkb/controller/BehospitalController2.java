package com.kkb.controller;

import com.kkb.bean.*;
import com.kkb.service.BehospitalService;
import com.kkb.service.ChargeprojectService;
import com.kkb.service.PricepeopleService;
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
@RequestMapping("charge2")
public class BehospitalController2 {
    @Resource
    private BehospitalService Bservice;
    @Resource
    private ChargeprojectService chargeprojectService;
    @Resource
    private PricepeopleService PService;

    /**
     * 动态查找数据库中的所有信息
     *
     * @param offset
     * @param pageNumber
     * @return
     */
    @RequestMapping("getAllCharge2")
    @ResponseBody
    public DataRe list(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                       @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
        //通过分页查询得到数据
        List<Behospital> behospitals = Bservice.getBeHospital(offset, pageNumber);
        List<BootStrapTableBehospital> list = new ArrayList<>();
        for (Behospital Behospital1 : behospitals) {
            String nurseName = Behospital1.getBehNursepeople() == "" ? "暂无名字" : Behospital1.getBehNursepeople();
            String patBed = Behospital1.getBehPatbed() == "" ? "暂无" : Behospital1.getBehPatbed();
            String money = Behospital1.getBehAntecedent().toString() == "" ? "暂无价格" : Behospital1.getBehAntecedent().toString();
            BootStrapTableBehospital Behospital2 = new BootStrapTableBehospital(Behospital1.getBehId(), nurseName, patBed, money);
            list.add(Behospital2);
        }
        //2. 将集合封装为 bootstrap-table识别的格式
        //查询总条数
        int total = Bservice.console();
        ResultData<BootStrapTableBehospital> data = new ResultData<>();
        data.setRows(list);
        data.setTotal(total);
        DataRe dataRe = new DataRe();
        dataRe.setData(data);
        return dataRe;
    }
    @RequestMapping("/look/{bId}")
    public String look(Model model, @PathVariable("bId") int bId) {
        List<Integer> cId = PService.selectByID(bId);
        List<BootStrapTableBC> getinfo=new ArrayList<>();
        List<BootStrapTableBC> list=new ArrayList() ;
        for (Integer cid : cId) {
            getinfo.addAll(Bservice.getinfo(bId, cid));
        }
        for (BootStrapTableBC bc : getinfo) {
            Integer behId = bc.getBehId();
            String nursepeople = bc.getNursepeople();
            String chapName = bc.getChapName();
            Double chapMoney = bc.getChapMoney();
            BootStrapTableBC b2 = new BootStrapTableBC(behId, nursepeople, chapName, chapMoney);

         list.add(b2);
        }

        model.addAttribute("list", list);
        return "hospital/account-look2";
    }

    /**
     * 更新信息
     *
     * @param
     * @return
     */
    @RequestMapping("update")
    @Transactional(rollbackFor = Exception.class)
    public String update(@RequestParam(value = "chapName") String chapName,
                         @RequestParam(value = "bId") Integer bId) {
        Chargeproject chargeproject = chargeprojectService.selectByName(chapName);
        Integer chapId = chargeproject.getChapId();
        PService.insert1(bId, chapId);
        return "redirect:/charge2/index";
    }

    @RequestMapping("/toInsert/{chapId}")
    public String toUpdate(@PathVariable("chapId") Integer chapId, Model model) {
        Behospital behospital = new Behospital();
        behospital.setBehId(chapId);
        Behospital tmp = Bservice.selectOne(behospital);
        model.addAttribute("tmp", tmp);
        return "/hospital/charge-new";


    }


    /**
     * 查询
     *
     * @param Behospital
     * @param model
     * @return
     */
    @RequestMapping("select")
    public String select(Behospital Behospital, Model model) {
        List<Behospital> list = new ArrayList<>();
        Behospital Behospital1 = Bservice.selectOne(Behospital);
        list.add(Behospital1);
        model.addAttribute("list", list);
        return "redirect:/charge/index";
    }


    /**
     * 跳转页面
     *
     * @param model
     * @return
     */
    @RequestMapping("index")
    public String index(Model model) {
        List<Behospital> list = Bservice.selectAll();
        model.addAttribute("list", list);
        return "/hospital/charge2";
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
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        List<Behospital> charges = new ArrayList<>();
        if (!(id.isEmpty() || id == null)) {
            charges.addAll(Bservice.selectByParams(Integer.parseInt(id), name));
        } else {
            charges.addAll(Bservice.selectByParams(-1, name));

        }
        List<BootStrapTableBehospital> chargeList = new ArrayList<>();
        for (Behospital b : charges) {
            chargeList.add(new BootStrapTableBehospital(b));
        }

        int total = Bservice.console();
        ResultData<BootStrapTableBehospital> data = new ResultData<>();
        data.setTotal(total);
        data.setRows(chargeList);
        DataRe dataRe = new DataRe();
        dataRe.setData(data);
        return dataRe;
    }

    @RequestMapping("findByParams2")
    @ResponseBody
    public String findByParams2(HttpServletRequest req) {
        String name = req.getParameter("name");
        String money = null;
        if (!(name.isEmpty() || name == null)) {
            money = chargeprojectService.selectByName2(name);
        }
        return money;

    }
}
