package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.BookAuthor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookAuthorRepository extends CrudRepository<BookAuthor,Long> {
    List<BookAuthor>findAllByBookId(Long bookId);
}
