package com.codegym.controllers;

import com.codegym.model.Students;
import com.codegym.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/students")
    public ModelAndView listStudents(){
        ModelAndView modelAndView = new ModelAndView("students/index");
        modelAndView.addObject("students", studentsService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-student")
    public ModelAndView showCreateStudent(){
        ModelAndView modelAndView = new ModelAndView("students/create");
        modelAndView.addObject("student", new Students());
        return modelAndView;
    }

    @PostMapping("/create-student")
    public String createStudent(@ModelAttribute Students student){
        studentsService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/edit-student/{id}")
    public ModelAndView showEditStudent(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("students/edit");
        modelAndView.addObject("student", studentsService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit-student")
    public ModelAndView editStudent(@ModelAttribute Students student){
        studentsService.save(student);
        ModelAndView modelAndView = new ModelAndView("students/edit");
        modelAndView.addObject("student", student);
        modelAndView.addObject("message", "Student Update successfully");
        return modelAndView;
    }

    @GetMapping("/delete-student/{id}")
    public ModelAndView showDeleteStudent(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("students/delete");
        modelAndView.addObject("student", studentsService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete-student")
    public String deleteStudent(@ModelAttribute Students student){
        studentsService.remove(student.getId());
        return "redirect:/students";
    }
}
