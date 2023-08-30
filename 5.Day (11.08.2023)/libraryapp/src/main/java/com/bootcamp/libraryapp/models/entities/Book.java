package com.bootcamp.libraryapp.models.entities;

public class Book {

    public Book(int id, String name, int categoryID, int authorID) {
        this.id = id;
        this.name = name;
        this.categoryID = categoryID;
        this.authorID = authorID;
    }

    private int id;
    private String name;
    private int categoryID;
    private int authorID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

}
