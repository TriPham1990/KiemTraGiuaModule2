package com.codegym.controllers;

import com.codegym.model.Classes;
import com.codegym.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @GetMapping("/classes")
    public ModelAndView listClass(){
        ModelAndView modelAndView = new ModelAndView("classes/index");
        modelAndView.addObject("classes", classesService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-class")
    public ModelAndView showCreateClass(){
        ModelAndView modelAndView = new ModelAndView("classes/create");
        modelAndView.addObject("classes", new Classes());
        return modelAndView;
    }

    @PostMapping("/create-class")
    public String createClass(@ModelAttribute Classes classes){
        classesService.save(classes);
        return "redirect:/classes";
    }

    @GetMapping("/edit-class/{id}")
    public ModelAndView showEditClass(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("classes/edit");
        modelAndView.addObject("classes", classesService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit-class")
    public ModelAndView editClass(@ModelAttribute Classes classes){
        classesService.save(classes);
        ModelAndView modelAndView = new ModelAndView("classes/edit");
        modelAndView.addObject("classes", classes);
        modelAndView.addObject("message", "Class update successfully");
        return modelAndView;
    }

    @GetMapping("/delete-class/{id}")
    public ModelAndView showDeleteClass(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("classes/delete");
        modelAndView.addObject("classes", classesService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete-class")
    public String deleteClass(@ModelAttribute Classes classes){
        classesService.remove(classes.getId());
        return "redirect:/classes";
    }
}
