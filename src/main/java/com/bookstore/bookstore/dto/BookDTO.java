package com.bookstore.bookstore.dto;

import com.bookstore.bookstore.entity.Author;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class BookDTO {
    private Long id;
    private String name;
    private String description;
    private Integer yearOfPublication;
    private String bookType;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private List<AuthorDTO>authors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public List<AuthorDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDTO> authors) {
        this.authors = authors;
    }
}
