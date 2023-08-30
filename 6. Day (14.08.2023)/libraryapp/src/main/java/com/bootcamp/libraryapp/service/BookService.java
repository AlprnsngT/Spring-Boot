package com.bootcamp.libraryapp.service;

import java.util.ArrayList;

import com.bootcamp.libraryapp.models.dto.BookDto;
import com.bootcamp.libraryapp.models.dto.UpdateBookNameAndAuthorIdDto;

public interface BookService {
    ArrayList<BookDto> getAllBooks();

    BookDto getBookById(int bookId);

    String deleteBookById(int bookId);

    int addBook(BookDto book);

    BookDto updateBook(int bookId, BookDto book);

    BookDto updateBookNameAndAuthorId(int bookId, UpdateBookNameAndAuthorIdDto book);

    ArrayList<BookDto> search(int categoryId, String bookName);

}
