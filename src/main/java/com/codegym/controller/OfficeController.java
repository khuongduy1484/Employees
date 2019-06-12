package com.codegym.controller;

import com.codegym.model.Office;
import com.codegym.sevice.OfficeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OfficeController {
    @Autowired
    private OfficeSevice officeSevice;
    @GetMapping("office")
    public ModelAndView listOffice(){
        ModelAndView modelAndView = new ModelAndView("offices/list");
        modelAndView.addObject("office",officeSevice.fillAll());
        return modelAndView;
    }
    @GetMapping("create-office")
    public ModelAndView createOffice(){
        ModelAndView modelAndView = new ModelAndView("offices/create");
        modelAndView.addObject("office",new Office());
        return modelAndView;
    }
    @PostMapping("create-office")
    public ModelAndView saveOffice(@ModelAttribute("office")Office office){
        ModelAndView modelAndView = new ModelAndView("offices/create");
        officeSevice.save(office);
        return modelAndView;
    }
    @GetMapping("edit-office/{id}")
    public ModelAndView editOffice(@PathVariable Long id){
        Office office = officeSevice.findById(id);
        ModelAndView modelAndView = new ModelAndView("offices/edit");
        modelAndView.addObject("office",office);
        return modelAndView;
    }
    @PostMapping("edit-office")
    public String updateOffice(@ModelAttribute("office") Office office){
        officeSevice.save(office);
        return "redirect:/office";
    }
    @GetMapping("delete-office/{id}")
    public ModelAndView deleteOffice(@PathVariable Long id){
        Office office =officeSevice.findById(id);
        ModelAndView modelAndView = new ModelAndView("offices/delete");
        modelAndView.addObject("office",office);
        return modelAndView;
    }
    @PostMapping("delete-office")
    public String deleteOffices(@ModelAttribute("office") Office office){
        officeSevice.delete(office.getId());
        return "redirect:/office";
    }

}
