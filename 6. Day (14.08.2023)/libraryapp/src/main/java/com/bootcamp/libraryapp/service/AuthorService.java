package com.bootcamp.libraryapp.service;

import java.util.ArrayList;

import com.bootcamp.libraryapp.models.dto.AuthorAddAndUpdateDto;
import com.bootcamp.libraryapp.models.dto.AuthorDto;

public interface AuthorService {

    ArrayList<AuthorDto> getAll();

    AuthorDto getById(int id);

    String deleteById(int id);

    int add(AuthorAddAndUpdateDto authorDto);

    AuthorDto update(int id, AuthorAddAndUpdateDto authorDto);
}
