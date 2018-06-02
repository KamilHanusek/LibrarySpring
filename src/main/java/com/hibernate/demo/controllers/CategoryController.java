package com.hibernate.demo.controllers;

import com.hibernate.demo.domain.Category;
import com.hibernate.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/category")
    public ModelAndView displayAll(@ModelAttribute Category category){
        Map<String,Iterable<Category>> map = new HashMap<>();
        map.put("categoryList",categoryService.getAll());
        return new ModelAndView("category",map);
    }
}
