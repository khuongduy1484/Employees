package com.codegym.controller;

import com.codegym.model.Employees;
import com.codegym.model.EmployeesForm;
import com.codegym.model.Office;
import com.codegym.sevice.EmployeessSevice;
import com.codegym.sevice.OfficeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class EmployeesController {
    private static   String UPLOAD_LOCATION= "/home/duy/module 2/session13/Employees/src/main/resources/image/";
    @Autowired
    private OfficeSevice officeSevice;
    @Autowired
    private EmployeessSevice employeessSevice;
    @ModelAttribute("office")
     public Iterable<Office>offices(){
        return officeSevice.fillAll();
    }
    @GetMapping("employees")
    public ModelAndView listEmployees(){
        ModelAndView modelAndView = new ModelAndView("employees/list");
        modelAndView.addObject("employees",employeessSevice.fillAll());
        return modelAndView;
    }
//
    @GetMapping("create-employees")
    public ModelAndView createEmployees(){
        ModelAndView modelAndView = new ModelAndView("employees/create");
        modelAndView.addObject("employeesform",new EmployeesForm());
        return modelAndView;
    }
    @PostMapping("create-employees")
    public String saveEmployees(@ModelAttribute("employeesform") EmployeesForm employeesform){
        MultipartFile multipartFile = employeesform.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try{
            FileCopyUtils.copy(employeesform.getImage().getBytes(),new File(UPLOAD_LOCATION +fileName));
        }catch (IOException ex){
            ex.printStackTrace();
        }
        Employees employees = new Employees(employeesform.getName(),employeesform.getYearOld(),employeesform.getEmail(),employeesform.getPhoneNumber(),employeesform.getAddress(),employeesform.getOffice(),fileName );
        employeessSevice.save(employees);
        return "redirect:/employees";
    }
    @GetMapping("edit-employees/{id}")
    public ModelAndView editEmployees(@PathVariable Long id){
        Employees employees = employeessSevice.findById(id);
        ModelAndView modelAndView = new ModelAndView("employees/edit");
        modelAndView.addObject("employees",employees);
        return modelAndView;
    }
    @PostMapping("edit-employees")
    public String updateOffice(@ModelAttribute("employees") Employees employees){
     employeessSevice.save(employees);
        return "redirect:/employees";
    }
    @GetMapping("delete-employees/{id}")
    public ModelAndView deleteEmployees(@PathVariable Long id){
      Employees employees = employeessSevice.findById(id);
        ModelAndView modelAndView = new ModelAndView("employees/delete");
        modelAndView.addObject("employees",employees);
        return modelAndView;
    }
    @PostMapping("delete-employees")
    public String deleteOffices(@ModelAttribute("employees") Employees employees){
       employeessSevice.delete(employees);
        return "redirect:/employees";
    }


}
