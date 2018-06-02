package com.hibernate.demo.dao;

import com.hibernate.demo.domain.Author;
import com.hibernate.demo.domain.Book;
import com.hibernate.demo.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface BookRepository extends CrudRepository<Book, Long> {

    public List<Book> findByTitleIgnoreCase(String title);
    public List<Book> findByAuthor(Author author);
    public List<Book> findByCategory(Category category);
}
