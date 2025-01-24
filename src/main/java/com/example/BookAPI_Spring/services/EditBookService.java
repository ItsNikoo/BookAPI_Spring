package com.example.BookAPI_Spring.services;

import com.example.BookAPI_Spring.models.Book;
import com.example.BookAPI_Spring.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class EditBookService {
    BookRepository bookRepository;

    @Autowired
    public EditBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void editBook(long id, String title, String author, String genre){
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        bookRepository.save(book);
    }

    public Book getBookById(long id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        return book;
    }
}
