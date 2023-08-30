package com.bootcamp.libraryapp.models.dto;

import java.util.ArrayList;
import java.util.Date;

public class AuthorWithBooksDto extends AuthorDto {

    private Date date;
    private String bio;
    private ArrayList<BookDto> books;
    private String language;

    public AuthorWithBooksDto(int id, String name) {
        super(id, name);
        this.books = new ArrayList<BookDto>();
    }

    public AuthorWithBooksDto(int id, String name, ArrayList<BookDto> books) {
        this(id, name);
        this.books = books;
    }

    public AuthorWithBooksDto(int id, String name, ArrayList<BookDto> books, String language) {
        this(id, name, books);
        this.language = language;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ArrayList<BookDto> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<BookDto> books) {
        this.books = books;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
