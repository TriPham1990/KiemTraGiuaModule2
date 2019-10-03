package com.codegym.formatter;

import com.codegym.model.Classes;
import com.codegym.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ClassesFormatter implements Formatter<Classes> {

    private ClassesService classesService;

    @Autowired
    public ClassesFormatter(ClassesService classesService) {
        this.classesService = classesService;
    }

    @Override
    public Classes parse(String text, Locale locale) throws ParseException {
        return classesService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Classes object, Locale locale) {
        return "[" + object.getId() + ", " +object.getNameClass() + "]";
    }
}
