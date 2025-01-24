package com.example.BookAPI_Spring.services;

import com.example.BookAPI_Spring.models.Book;
import com.example.BookAPI_Spring.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddBookService {

    BookRepository bookRepository;

    @Autowired
    public AddBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title, String author, String genre) {
        bookRepository.save(new Book(title, author, genre));
    }

}
