package com.bootcamp.libraryapp.models.dto;

import java.util.ArrayList;

public class AuthorWithBooksDto extends AuthorDto {

    private ArrayList<BookDto> books;

    private String language;

    public AuthorWithBooksDto(int id, String name) {
        super(id, name); // super(); üst sınıfın constructoru çağırabilmek için kullanılır.
        // TODO Auto-generated constructor stub
        this.books = new ArrayList<BookDto>(); // private ArrayList<BookDto> books = new ArrayList<BookDto>(); olarak da
                                               // yazabiliriz.
    }

    // SMART CONSTRUCTOR
    public AuthorWithBooksDto(int id, String name, ArrayList<BookDto> books) {
        /*
         * burada süper çağırmak yerine id ve name veren constructor tnaımlamıştık
         * o yüzden o constructora atıf yapabiliriz
         */
        this(id, name); // bu this ile bu classdaki constructora atıf yapıyor.
        this.books = books;
    }

    public AuthorWithBooksDto(int id, String name, ArrayList<BookDto> books, String language) {
        /*
         * burada süper çağırmak yerine id ve name veren constructor tnaımlamıştık
         * o yüzden o constructora atıf yapabiliriz
         */
        this(id, name, books); // bu this ile bu classdaki constructora atıf yapıyor.
        this.language = language;
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
