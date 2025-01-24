package com.example.BookAPI_Spring.controllers;


import com.example.BookAPI_Spring.models.Book;
import com.example.BookAPI_Spring.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    private BookRepository bookRepository;

    @Autowired
    public MainController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "index";
    }

    /*@GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable Long id, Model model) {
        try{
            Book book = bookRepository.findById(id).get();
            model.addAttribute("book", book);
        }catch (Exception e){
            model.addAttribute("error", "Book not found");
            return "redirect:/";
        }
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String postEdit(@PathVariable Long id, @RequestParam String title, @RequestParam String author, @RequestParam String genre, Model model) {
        try {
            Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
            book.setTitle(title);
            book.setAuthor(author);
            book.setGenre(genre);
            bookRepository.save(book);
            model.addAttribute("book", book);
        } catch (Exception e) {
            model.addAttribute("error", "Book not found");
            return "redirect:/";
        }
        return "redirect:/";
    }*/
}
