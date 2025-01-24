package com.example.BookAPI_Spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.example.BookAPI_Spring.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
