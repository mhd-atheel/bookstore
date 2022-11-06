package com.bookstore.bookstore.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
@Entity
public class BookAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id" ,nullable = false)
    private Book book;
    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "id" ,nullable = false)
    private Author author;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
