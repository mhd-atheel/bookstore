package com.bookstore.bookstore.controller;


import com.bookstore.bookstore.common.APIResponse;
import com.bookstore.bookstore.dto.BookDTO;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Set;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books" ,method = RequestMethod.GET)
    public List<Book>getBooks(@RequestParam(value = "yearOfPublication",required = false) Set<Integer> yop,
                              @RequestParam(value = "bookType" ,required = false) String bookType){
        return bookService.getBooks(yop,bookType);
    }
   @PostMapping(value = "/books")
    public Book createBook(@RequestBody Book book){
       return bookService.createBook(book);
    }
    @GetMapping(value = "/books/{id}")
    public BookDTO getBookId(
        @PathVariable("id") Long bookId,
        @RequestParam(value = "authorData",required = false) boolean authorData
        ){
        return bookService.getBookByID(bookId,authorData);
        }


    @PutMapping(value = "/books")
    public Book updateBook(@RequestBody Book incomingBook){
        return bookService.updateBook(incomingBook);
    }
    @DeleteMapping(value = "books/{id}")
    public String deleteBookById(@PathVariable("id")Long bookid){
        return bookService.deleteBookById(bookid);
    }

    @GetMapping( value = "/raw/books")
    public APIResponse getBookByRawQuery(@RequestParam(value = "yop") Set<Integer> yop){
        return bookService.getgetBookByRawQuery(yop);
    }
}
