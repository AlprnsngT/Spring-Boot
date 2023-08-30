package com.bootcamp.libraryapp.models.dto;

public class UpdateBookNameAndAuthorIdDto {
    private String bookName;
    private int authorID;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

}
