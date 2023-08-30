package com.bootcamp.libraryapp.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.libraryapp.models.dto.BookDto;
import com.bootcamp.libraryapp.models.dto.UpdateBookNameAndAuthorIdDto;
import com.bootcamp.libraryapp.service.BookService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "")
    public ResponseEntity<ArrayList<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") int bookID) {
        BookDto book = bookService.getBookById(bookID);
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

    @PostMapping(value = "")
    public ResponseEntity<Integer> addBook(@RequestBody BookDto bookDto) {
        ResponseEntity<Integer> ok = ResponseEntity.ok(bookService.addBook(bookDto));
        return ok;

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") int bookId, @RequestBody BookDto book) {
        return ResponseEntity.ok(bookService.updateBook(bookId, book));

    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<BookDto> updateBookNameAndAuthorId(@PathVariable("id") int bookId,
            @RequestBody UpdateBookNameAndAuthorIdDto book) {
        return ResponseEntity.ok(bookService.updateBookNameAndAuthorId(bookId, book));
    }

    @GetMapping(value = "/search")
    public Object search(@RequestParam("catId") int categoryID,@RequestParam(name = "bookname", required = false) String bookname) {

        ArrayList<BookDto> searchList = bookService.search(categoryID, bookname);

        if (searchList.size() > 0) {
            // return ResponseEntity.ok(searchList);
            return searchList;
        } else {
            // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aranılan kayıt
            // bulunamadı.");
            return "Kayıt bulunamadı.";
        }

    }

}
