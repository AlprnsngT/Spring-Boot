package com.bootcamp.libraryapp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.bootcamp.libraryapp.models.dto.AuthorAddAndUpdateDto;
import com.bootcamp.libraryapp.models.dto.AuthorDto;

@Service
public class AuthorServiceImpl implements AuthorService {

    private ArrayList<AuthorDto> authors = new ArrayList<AuthorDto>();

    public AuthorServiceImpl() {
        AuthorDto author1 = new AuthorDto(1, "Mehmet");
        AuthorDto author2 = new AuthorDto(2, "Reşit");
        AuthorDto author3 = new AuthorDto(3, "Çağan");
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
    }

    @Override
    public ArrayList<AuthorDto> getAll() {
        return authors;
    }

    @Override
    public AuthorDto getById(int id) {
        AuthorDto author = authors.stream().filter(x -> x.getId() == id).findFirst().get();
        return author;
    }

    @Override
    public String deleteById(int id) {
        AuthorDto author = getById(id);
        authors.remove(author);
        return "deleted author: " + author.getName();
    }

    @Override
    public int add(AuthorAddAndUpdateDto authorDto) {
        AuthorDto newRecord = new AuthorDto(authorDto.getId(), authorDto.getName());
        authors.add(newRecord);
        return newRecord.getId();
    }

    @Override
    public AuthorDto update(int id, AuthorAddAndUpdateDto authorDto) {
        AuthorDto author = getById(id);
        author.setName(authorDto.getName());
        return author;
    }

}
