package com.bootcamp.libraryapp.models.dto;

import java.util.Date;

public class AuthorAddAndUpdateDto extends AuthorDto {
    private Date date;
    private String bio;

    public AuthorAddAndUpdateDto(int id, String name) {
        super(id, name);
        // TODO Auto-generated constructor stub
    }

    // constructor kısayolu CTOR
    public AuthorAddAndUpdateDto(int id, String name, Date date) {
        this(id, name);
        this.date = date;
        // TODO Auto-generated constructor stub
    }

    public AuthorAddAndUpdateDto(int id, String name, String bio) {
        this(id, name);
        this.bio = bio;
        // TODO Auto-generated constructor stub
    }

    public AuthorAddAndUpdateDto(int id, String name, Date date, String bio) {
        this(id, name,date);
        this.bio = bio;

        // TODO Auto-generated constructor stub
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

}
