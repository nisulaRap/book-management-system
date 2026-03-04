package com.example.book_service.controller;

import com.example.book_service.model.Book;
import com.example.book_service.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) { this.bookService = bookService; }

    @GetMapping
    public List<Book> getBooks() { return bookService.getAllBooks(); }

    @PostMapping
    public Book createBook(@RequestBody Book book) { return bookService.addBook(book); }
}
