package com.hibernate.demo.controllers;
import com.hibernate.demo.domain.Author;
import com.hibernate.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @RequestMapping("/authors")
    public ModelAndView displayAll(@ModelAttribute Author author){

        Iterable<Author> authors = authorService.getAll();
        Map<String, Iterable<Author>> map = new HashMap<>();
        map.put("authorList",authors);
        return new ModelAndView("authors",map);
    }
}
