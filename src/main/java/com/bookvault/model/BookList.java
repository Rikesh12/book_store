package com.bookvault.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book_list")
public class BookList {

    @Id
    private int id;
    private String name;
    private String author;
    private String price;

    public BookList(int id, String name, String author, String price) {

        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public BookList() {
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPrice() {
        return price;
    }
}
