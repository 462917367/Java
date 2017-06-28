package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pojo.Emp;
import service.EmpService;
import util.EmpUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/6/27 0027.
 */

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    //登录主界面
    @RequestMapping("/selectAll")
    public String findAll(ModelMap modelMap) {
        List<Emp> empList = empService.findAll();
        modelMap.addAttribute("emps",empList);
        return "mainframe";
    }

    //模糊查询
    @RequestMapping("/selectByInfo")
    public String findByInfo(String info,ModelMap modelMap) {
        List<Emp> empList = empService.findByInfo(info);
        modelMap.addAttribute("emps",empList);
        return "mainframe";
    }

    //获取empid，将empid传到新建界面
    @RequestMapping("/getId")
    public String getId(ModelMap map){
        String eid = EmpUtil.getEmpid();
        Emp emp = empService.findById(eid);
        while (true){
            if(emp!=null) {
                eid = EmpUtil.getEmpid();
            }else {
                map.addAttribute("eid",eid);
                return "newemp";
            }
        }
    }

    //新建
    @RequestMapping("/newone")
    public String add(Emp emp, @RequestParam("file")MultipartFile file,ModelMap modelMap) {
        try {
            byte [] bytes = new byte[file.getInputStream().available()];
            file.getInputStream().read(bytes);
            emp.setPhoto(bytes);
            empService.add(emp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Emp> empList = empService.findAll();
        modelMap.addAttribute("emps",empList);
        return "mainframe";
    }

    //根据empid查找所有信息传到修改界面
    @RequestMapping("/findById")
    public String findById(String empid,ModelMap modelMap){
        Emp emp = empService.findById(empid);
        modelMap.addAttribute("emps",emp);
        return "alteremp";
    }

    //修改
    @RequestMapping("/alterone")
    public String alter(Emp emp,@RequestParam("file")MultipartFile file,ModelMap modelMap) {
        try {
            byte[] bytes = new byte[file.getInputStream().available()];
            file.getInputStream().read(bytes);
            emp.setPhoto(bytes);
            empService.alter(emp);
        }catch (IOException e0) {
            e0.printStackTrace();
        }
        List<Emp> empList = empService.findAll();
        modelMap.addAttribute("emps",empList);
        return "mainframe";
    }

    //删除
    @RequestMapping("/deleteone")
    public String remove(String empid,ModelMap modelMap) {
        empService.remove(empid);
        List<Emp> empList = empService.findAll();
        modelMap.addAttribute("emps",empList);
        return "mainframe";
    }

    //显示图片
    @RequestMapping(value="/toLookImage",method = RequestMethod.GET)
    public void getSelectPhoto(@RequestParam("eid") String empid,ModelMap modelMap, HttpServletResponse response){
        Emp emp = empService.findById(empid);
        byte[] data=emp.getPhoto();
        response.setContentType("img/jpeg");
        response.setCharacterEncoding("utf-8");
        try {
            OutputStream outputStream=response.getOutputStream();
            InputStream in=new ByteArrayInputStream(data);
            int len=0;
            byte[]buf=new byte[1024];
            while((len=in.read(buf,0,1024))!=-1){
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
