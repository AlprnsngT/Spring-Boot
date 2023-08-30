package com.bootcamp.libraryapp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.bootcamp.libraryapp.models.dto.BookDto;
import com.bootcamp.libraryapp.models.dto.UpdateBookNameAndAuthorIdDto;

//import com.bootcamp.libraryapp.models.entities.Book;
@Service
public class BookServiceImpl implements BookService {

    @Override
    public ArrayList<BookDto> getAllBooks() {
        return new ArrayList<BookDto>();
    }

    @Override
    public BookDto getBookById(int bookId) {
        BookDto bookDto = new BookDto();
        bookDto.setId(bookId);
        return bookDto;
    }

    @Override
    public String deleteBookById(int bookId) {
        return "done";
    }

    @Override
    public int addBook(BookDto book) {
        return book.getId();
    }

    @Override
    public BookDto updateBook(int bookId, BookDto book) {
        return book;
    }

    @Override
    public BookDto updateBookNameAndAuthorId(int bookId, UpdateBookNameAndAuthorIdDto book) {
        BookDto bookDto = new BookDto();
        bookDto.setName(book.getBookName());
        bookDto.setAuthorID(book.getAuthorID());
        return bookDto;
    }

    @Override
    public ArrayList<BookDto> searchMethod(int categoryID, String name) {
        // TODO Auto-generated method stub
        ArrayList<BookDto> bookList = new ArrayList<BookDto>();
        BookDto book = new BookDto();

        if (categoryID > 10) {

            book.setCategoryID(categoryID);
            if (name != null) {
                book.setName(name);
            } else {
                book.setName("None");
            }
            bookList.add(book);
        } else {

        }

        return bookList;

    }

}
