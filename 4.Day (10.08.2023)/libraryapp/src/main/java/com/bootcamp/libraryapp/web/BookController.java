package com.bootcamp.libraryapp.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import com.bootcamp.libraryapp.models.dto.BookDto;
import com.bootcamp.libraryapp.models.dto.UpdateBookNameAndAuthorIdDto;
//import com.bootcamp.libraryapp.models.entities.Book;
import com.bootcamp.libraryapp.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "path")
    public ResponseEntity<ArrayList<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") int bookId) {
        BookDto book = new BookDto();
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") int bookId) {
        return ResponseEntity.ok(bookService.deleteBookById(bookId));
    }

    @PostMapping(value = "")  // -url değerine gerek yok body istiyorum
    public ResponseEntity<Integer> addBook(@RequestBody BookDto bookDto) {
        // TODO: process POST request
        /*
        * Bu işlemin kısası
        *int recordId = bookService.addBook(bookDto);
        *return ResponseEntity.ok(recordId);
        */
        return ResponseEntity.ok(bookService.addBook(bookDto));
    }

    @PutMapping(value = "/{id}") 
    /*
    *urlde id alıyoruz
    *urldeki id sahi veriyi güncelle
    *body den değiştirmek istediğiiz şeyleri giriyoruz.
    */
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") int bookId, @RequestBody BookDto book) {
        // TODO: process PUT request

        return ResponseEntity.ok(bookService.updateBook(bookId, book));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<BookDto> updateBookNameAndAuthorId(@PathVariable("id") int bookId, @RequestBody UpdateBookNameAndAuthorIdDto book) {
        return ResponseEntity.ok(bookService.updateBookNameAndAuthorId(bookId, book));
    }

}
