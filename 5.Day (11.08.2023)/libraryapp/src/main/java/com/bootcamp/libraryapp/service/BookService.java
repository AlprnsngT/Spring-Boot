package com.bootcamp.libraryapp.service;

import java.util.ArrayList;

//import org.springframework.stereotype.Service;

import com.bootcamp.libraryapp.models.dto.BookDto;
import com.bootcamp.libraryapp.models.dto.UpdateBookNameAndAuthorIdDto;
//import com.bootcamp.libraryapp.models.entities.Book;

public interface BookService {
    ArrayList<BookDto> getAllBooks();

    BookDto getBookById(int bookId);

    String deleteBookById(int bookId);

    int addBook(BookDto book);

    BookDto updateBook(int bookId, BookDto book);

    BookDto updateBookNameAndAuthorId(int bookId, UpdateBookNameAndAuthorIdDto book);

    ArrayList<BookDto> searchMethod(int categoryID, String name);

}
