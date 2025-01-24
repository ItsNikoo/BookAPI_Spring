package com.example.BookAPI_Spring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotEmpty(message = "Title is required")
    private String title;
    @NotEmpty(message = "Author is required")
    private String author;
    @NotEmpty(message = "Genre is required")
    private String genre;

    public Book() {
    }

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
