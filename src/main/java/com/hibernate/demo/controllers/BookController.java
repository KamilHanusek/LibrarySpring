package com.hibernate.demo.controllers;

import com.hibernate.demo.domain.Author;
import com.hibernate.demo.domain.Book;
import com.hibernate.demo.domain.Category;
import com.hibernate.demo.service.AuthorService;
import com.hibernate.demo.service.BookService;
import com.hibernate.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @Autowired
    CategoryService categoryService;

    BookController(){}
    @RequestMapping("/books")
    public ModelAndView displayAll(@ModelAttribute Book book){

        Iterable<Book> books = bookService.getAll();
        Map<String, Iterable<Book>> map = new HashMap<>();
        map.put("booksList",books);
        return new ModelAndView("books",map);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public ModelAndView displayById(@PathVariable("id") Long id){
        Map<String, Book> map = new HashMap<>();
        map.put("oneBook",bookService.getById(id));
        return new ModelAndView("bookById", map);
    }

    @RequestMapping(value = "books/{id}/deleted")
    public ModelAndView deleteById(@PathVariable("id") Long id){
        bookService.deleteById(id);
        Iterable<Book> books = bookService.getAll();
        Map<String, Iterable<Book>> map = new HashMap<>();
        map.put("booksList", books);
        return new ModelAndView("books",map);
    }

    @RequestMapping(value = "/books/add")
    public String goToAddBook(){
        return "add";
    }

    @RequestMapping(value = "books/add/properties", method = RequestMethod.GET)
    public ModelAndView addBook(@RequestParam String title,
                                @RequestParam String authorId,
                                @RequestParam String categoryId,
                                @RequestParam String size
                                ){
        try{
            Author auth =authorService.getById(Long.parseLong(authorId));
            Category cat = categoryService.getById(Long.parseLong(categoryId));
            bookService.addBook(new Book(cat,auth,title,Integer.parseInt(size)));
        }catch (Exception ex){
            return new ModelAndView("home");
        }
        Iterable<Book> books = bookService.getAll();
        Map<String, Iterable<Book>> map = new HashMap<>();
        map.put("booksList", books);
        return new ModelAndView("books",map);
    }
}
