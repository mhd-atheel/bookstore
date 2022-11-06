package com.bookstore.bookstore.controller;


import com.bookstore.bookstore.entity.Author;
import com.bookstore.bookstore.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping(value = "/author")
    Author createAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }

}
