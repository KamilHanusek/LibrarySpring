package com.hibernate.demo.service;

import com.hibernate.demo.dao.AuthorRepository;
import com.hibernate.demo.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Iterable<Author> getAll(){
       return authorRepository.findAll();
    }

    public Author getById(long id){
        return authorRepository.findOne(id);
    }

    public List<Author> getByName(String name){
        return authorRepository.findByNameIgnoreCase(name);
    }

    public List<Author> getByLastname(String lastname){
        return authorRepository.findByLastnameIgnoreCase(lastname);
    }

    public List<Author> getByAge(int age){
        return authorRepository.findByAge(age);
    }

    public void addAuthor(Author author){
        authorRepository.save(author);
    }

    public void deleteAuthore(long id){
        authorRepository.delete(id);
    }
}
