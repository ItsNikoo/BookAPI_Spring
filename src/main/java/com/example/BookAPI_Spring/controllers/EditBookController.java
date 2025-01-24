package com.example.BookAPI_Spring.controllers;

import com.example.BookAPI_Spring.models.Book;
import com.example.BookAPI_Spring.services.EditBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditBookController {
    private EditBookService editBookService;

    @Autowired
    public EditBookController(EditBookService editBookService) {
        this.editBookService = editBookService;
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, @RequestParam String title, @RequestParam String author, @RequestParam String genre, Model model){
        editBookService.editBook(id, title, author, genre);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String ShowEditBookForm(@PathVariable Long id, Model model){
        Book book = editBookService.getBookById(id);
        model.addAttribute("book", book);
        return "edit";
    }
}
