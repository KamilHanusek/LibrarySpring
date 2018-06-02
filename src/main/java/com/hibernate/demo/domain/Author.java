package com.hibernate.demo.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String lastname;
    private int age;

    @ManyToMany
    private Set<Book> books;

    public Author(){
        //hibernate wants it
        //cant have a bean without no-args constructor, because hibernate creates no-args object and set its properties via setters
    }

    public Author(String name, String lastname, int age){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public String getLastname(){
        return lastname;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString(){
        return name + " " + lastname;
    }
}
