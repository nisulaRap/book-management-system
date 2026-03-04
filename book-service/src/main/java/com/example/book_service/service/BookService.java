package com.example.book_service.service;

import com.example.book_service.model.Book;
import com.example.book_service.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final RestTemplate restTemplate;

    public BookService(BookRepository bookRepository, RestTemplate restTemplate) {
        this.bookRepository = bookRepository;
        this.restTemplate = restTemplate;
    }

    public List<Book> getAllBooks() { return bookRepository.findAll(); }

    public Book addBook(Book book) {
        // Save book
        Book savedBook = bookRepository.save(book);

        // Inter-service communication: Notify User Service
        String userServiceUrl = "http://user-service:8081/users/" + book.getUserId();
        Object user = restTemplate.getForObject(userServiceUrl, Object.class);
        System.out.println("Book added for user: " + user);

        return savedBook;
    }
}
