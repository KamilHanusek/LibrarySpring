package com.hibernate.demo.controllers;

import com.hibernate.demo.domain.Book;
import com.hibernate.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/books")
    public ModelAndView displayAll(@ModelAttribute Book book){

        Iterable<Book> books = bookService.getAll();
        Map<String, Iterable<Book>> map = new HashMap<>();
        map.put("booksList",books);
        return new ModelAndView("books",map);
    }
}
