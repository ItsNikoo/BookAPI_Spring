package com.example.BookAPI_Spring.controllers;

import com.example.BookAPI_Spring.models.Book;
import com.example.BookAPI_Spring.repositories.BookRepository;
import com.example.BookAPI_Spring.services.AddBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddBookController {

    private AddBookService addBookService;

    @Autowired
    public AddBookController(AddBookService addBookService) {
        this.addBookService = addBookService;
    }

    @GetMapping("/add")
    public String ShowAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String title, @RequestParam String author, @RequestParam String genre, Model model) {
        addBookService.addBook(title,author,genre);
        return "redirect:/";
    }
}
