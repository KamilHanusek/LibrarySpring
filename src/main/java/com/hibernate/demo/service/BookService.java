package com.hibernate.demo.service;

import com.hibernate.demo.dao.BookRepository;
import com.hibernate.demo.domain.Author;
import com.hibernate.demo.domain.Book;
import com.hibernate.demo.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Iterable<Book> getAll(){
        return bookRepository.findAll();
    }
    public Book getById(Long id){
        return bookRepository.findOne(id);
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public Book deleteById(Long id) {
        bookRepository.delete(id);
        return null;
    }
}
