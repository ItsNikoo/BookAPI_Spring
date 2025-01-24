package com.example.BookAPI_Spring.controllers;

import com.example.BookAPI_Spring.services.DeleteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DeleteBookController {
    private final DeleteBookService deleteBookService;

    @Autowired
    public DeleteBookController(DeleteBookService deleteBookService) {
        this.deleteBookService = deleteBookService;
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        deleteBookService.deleteBook(id);
        return "redirect:/";
    }
}
