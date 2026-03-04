package com.example.book_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String title;
    private String authorName;
    private String userId; // To link book to user

    public Book() {}
    public Book(String title, String authorName, String userId) {
        this.title = title;
        this.authorName = authorName;
        this.userId = userId;
    }

    // getters and setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}
