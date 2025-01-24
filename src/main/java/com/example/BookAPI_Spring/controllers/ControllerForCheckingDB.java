package com.example.BookAPI_Spring.controllers;

import com.example.BookAPI_Spring.models.Book;
import com.example.BookAPI_Spring.repositories.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/check")
public class ControllerForCheckingDB {
    private final BookRepository bookRepository;

    public ControllerForCheckingDB(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/check")
    public List<Book> check() {
        List<Book> books = bookRepository.findAll();
        return books;
    }
}
