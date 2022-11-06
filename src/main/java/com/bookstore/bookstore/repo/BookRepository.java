package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
   List<Book>findAllByYearOfPublicationInAndBookType(Set<Integer> yop ,String bookType);

    List<Book> findAllByYearOfPublicationIn(Set<Integer> yop);
}
