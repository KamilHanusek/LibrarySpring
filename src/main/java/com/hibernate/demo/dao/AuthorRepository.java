package com.hibernate.demo.dao;

import com.hibernate.demo.domain.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    public List<Author> findByNameIgnoreCase(String name);
    public List<Author> findByLastnameIgnoreCase(String lastname);
    public List<Author> findByAge(int age);
}
