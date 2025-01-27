package com.example.BookAPI_Spring.controllers;


import com.example.BookAPI_Spring.models.Book;
import com.example.BookAPI_Spring.repositories.BookRepository;
import com.example.BookAPI_Spring.services.AddBookService;
import com.example.BookAPI_Spring.services.DeleteBookService;
import com.example.BookAPI_Spring.services.EditBookService;
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
    private AddBookService addBookService;
    private DeleteBookService deleteBookService;
    private EditBookService editBookService;

    public MainController(BookRepository bookRepository, AddBookService addBookService, DeleteBookService deleteBookService, EditBookService editBookService) {
        this.bookRepository = bookRepository;
        this.addBookService = addBookService;
        this.deleteBookService = deleteBookService;
        this.editBookService = editBookService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "index";
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

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        deleteBookService.deleteBook(id);
        return "redirect:/";
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
