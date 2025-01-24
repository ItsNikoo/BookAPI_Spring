package com.example.BookAPI_Spring.controllers;

import com.example.BookAPI_Spring.models.Book;
import com.example.BookAPI_Spring.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerForCheckingBook {
    private final BookRepository bookRepository;

    @Autowired
    public ControllerForCheckingBook(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/check/{id}")
    public Book checkBook(@PathVariable Long id) {
        Book book  = bookRepository.findById(id).orElse(null);
        return book;
    }
}
