package com.example.BookAPI_Spring.services;

import com.example.BookAPI_Spring.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteBookService {
    private final BookRepository bookRepository;

    @Autowired
    public DeleteBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
