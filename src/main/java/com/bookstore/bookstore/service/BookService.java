package com.bookstore.bookstore.service;

import com.bookstore.bookstore.common.APIResponse;
import com.bookstore.bookstore.data.BookData;
import com.bookstore.bookstore.dto.AuthorDTO;
import com.bookstore.bookstore.dto.BookDTO;
import com.bookstore.bookstore.entity.Author;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.BookAuthor;
import com.bookstore.bookstore.repo.BookAuthorRepository;
import com.bookstore.bookstore.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
   @Autowired
   private BookRepository bookRepository;
   @Autowired
   private BookAuthorRepository bookAuthorRepository;
    public List<Book>getBooks(Set<Integer> yop,String bookType){
        List<Book> bookList = new ArrayList<>();
        if(yop == null){
            bookRepository.findAll().forEach(book -> bookList.add(book));

        }else {
           return bookRepository.findAllByYearOfPublicationInAndBookType(yop,bookType);
        }
        return bookList;
    }
    public Book createBook(Book book){
       return bookRepository.save(book);
    }
    public BookDTO getBookByID(Long bookid , Boolean authorData){
        Optional<Book> book;
        book= bookRepository.findById(bookid);
        List<BookAuthor> bookAuthors = null;

        if(authorData){
            bookAuthors= bookAuthorRepository.findAllByBookId(bookid);
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.get().getId());
        bookDTO.setName(book.get().getName());
        bookDTO.setDescription(book.get().getDescription());
        bookDTO.setYearOfPublication(book.get().getYearOfPublication());
        bookDTO.setBookType(book.get().getBookType());

        List<AuthorDTO>authorDTOList =new ArrayList<>();
        if(bookAuthors != null) {
            for (BookAuthor bookAuthor : bookAuthors) {
                Author author = bookAuthor.getAuthor();
                AuthorDTO authorDTO = new AuthorDTO();
                authorDTO.setId(author.getId());
                authorDTO.setName(author.getName());
                authorDTO.setGender(author.getGender());
                authorDTOList.add(authorDTO);
            }
            bookDTO.setAuthors(authorDTOList);
        }
            return bookDTO;

    }

    public Book updateBook(Book incomingBook) {
      return bookRepository.save(incomingBook);
    }

    public String deleteBookById(Long bookid) {
        bookRepository.deleteById(bookid);
        return "Deleted SuccessFully";
    }

    public APIResponse getgetBookByRawQuery(Set<Integer> yop) {
        APIResponse apiResponse = new APIResponse();
        List<Book> bookList = bookRepository.findAllByYearOfPublicationIn(yop);
//        Map data = new HashMap();
//        data.put("books",bookList);
        BookData bookData = new BookData();
        bookData.setBooks(bookList);

        apiResponse.setData(bookData);
        return apiResponse;
    }
}
