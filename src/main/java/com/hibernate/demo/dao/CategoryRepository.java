package com.hibernate.demo.dao;

import com.hibernate.demo.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    public List<Category> findByNameIgnoreCase(String name);

}
