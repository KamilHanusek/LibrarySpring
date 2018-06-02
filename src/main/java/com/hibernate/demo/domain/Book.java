package com.hibernate.demo.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Category category;

    @OneToOne
    private Author author;

    private String title;
    private int size;

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAuthor(Author authors) {
        this.author = authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

    public long getId() {
        return id;
    }

    public Book(Category category, Author authors, String title, int size) {

        this.category = category;
        this.author = authors;
        this.title = title;
        this.size = size;
    }
    public Book( ){}
}
