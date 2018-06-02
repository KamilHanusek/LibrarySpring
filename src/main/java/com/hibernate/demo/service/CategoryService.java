package com.hibernate.demo.service;

import com.hibernate.demo.dao.CategoryRepository;
import com.hibernate.demo.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Iterable<Category> getAll(){
       return categoryRepository.findAll();
    }

    public List<Category> getByName(String name){
        return categoryRepository.findByNameIgnoreCase(name);
    }

    public Category getById(long id){
        return categoryRepository.findOne(id);
    }

    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategory(long id){
        categoryRepository.delete(id);
    }
}
