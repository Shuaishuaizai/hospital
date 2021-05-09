package com.kkb.controller;

import com.kkb.bean.BootStrapTableDoctor;
import com.kkb.bean.Doctor;
import com.kkb.bean.Hosregister;
import com.kkb.service.DoctorService;
import com.kkb.util.DataRe;
import com.kkb.util.ResultData;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/doctor")
public class DoctorController {

    @Resource
    DoctorService doctorService;

    @RequestMapping("/index")
    public String index(Model model){
        List<Doctor> list = doctorService.selectAll();
        model.addAttribute("listDoctor",list);
        return "/Doctor/index";
    }
    @RequestMapping("/toUpdate/{dId}")
    public String toUpdate(@PathVariable("dId") int dId,Model model){
        Doctor d = new Doctor();
        d.setdId(dId);
        Doctor doctor = doctorService.selectOne(d);
        BootStrapTableDoctor tmp = new BootStrapTableDoctor(doctor);
        model.addAttribute("tmp",tmp);
        return "/Doctor/edit";
    }
    @RequestMapping("/update")
    public String update(Doctor doctor){
        System.out.println(doctor.getdName());
        int i = doctorService.update(doctor);
        if(i > 0){
            return "redirect:/doctor/index";
        }
        else{
            return "/Doctor/edit";
        }
    }
    @RequestMapping("/insert")
    public String insert(Doctor doctor){
        int i = doctorService.insert(doctor);
        if(i > 0){
            return "redirect:/doctor/index";
        }
        else{
            return "/Doctor/add";
        }
    }
    @RequestMapping("/toInsert")
    public String toInsert(){
        return "/Doctor/add";
    }


    @RequestMapping("/look/{dId}")
    public String look(Model model,@PathVariable("dId") int dId){
        Doctor doctor = new Doctor();
        doctor.setdId(dId);
        Doctor tmp = doctorService.selectOne(doctor);
        BootStrapTableDoctor bd = new BootStrapTableDoctor(tmp);
        model.addAttribute("tmp",bd);
        return "Doctor/look";
    }

    @RequestMapping("getAllDoctors")
    @ResponseBody
    public DataRe getAll(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                         @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
        List<Doctor> doctors = doctorService.getDoctors(offset, pageNumber);
        List<BootStrapTableDoctor> doctorList = new ArrayList<>();
        for(Doctor d : doctors){
            doctorList.add(new BootStrapTableDoctor(d));
        }
        int total = doctorService.console();
        ResultData<BootStrapTableDoctor> data = new ResultData<>();
        data.setTotal(total);
        data.setRows(doctorList);
        DataRe dataRe = new DataRe();
        dataRe.setData(data);
        return dataRe;
    }

    @RequestMapping("findByParams")
    @ResponseBody
    public DataRe findByParams(HttpServletRequest req) {
        String name = req.getParameter("name");
        String id = req.getParameter("id");
        String keshi = req.getParameter("keshi");
        System.out.println(keshi);
        List<Doctor> doctors = new ArrayList<Doctor>();
        if(!(id.isEmpty()||id==null)) {
            doctors.addAll(doctorService.selectByParams(Integer.parseInt(id), name, keshi));
        }else{
            doctors.addAll(doctorService.selectByParams(-1,name, keshi));
        }
        List<BootStrapTableDoctor> doctorList = new ArrayList<>();
        for(Doctor d : doctors){
            doctorList.add(new BootStrapTableDoctor(d));
        }
        int total = doctorService.console();
        ResultData<BootStrapTableDoctor> data = new ResultData<>();
        data.setTotal(total);
        data.setRows(doctorList);
        DataRe dataRe = new DataRe();
        dataRe.setData(data);
        return dataRe;
    }
}
