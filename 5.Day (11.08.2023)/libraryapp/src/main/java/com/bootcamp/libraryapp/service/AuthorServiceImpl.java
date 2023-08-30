package com.bootcamp.libraryapp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.constructor.Construct;

import com.bootcamp.libraryapp.models.dto.AuthorAddAndUpdateDto;
import com.bootcamp.libraryapp.models.dto.AuthorDto;

@Service
public class AuthorServiceImpl implements AuthorService {

    private ArrayList<AuthorDto> authors = new ArrayList<AuthorDto>();

    public AuthorServiceImpl() {// database olmadığı için sanki varmış gibi bu şekilde kullanmak için böyle yapıyoruz.
        AuthorDto author1 = new AuthorDto(1, "alperen");
        AuthorDto author2 = new AuthorDto(1, "namık");
        AuthorDto author3 = new AuthorDto(1, "emre");
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
    }

    @Override
    public ArrayList<AuthorDto> getAll() {
        // TODO Auto-generated method stub
        return authors;
    }

    @Override
    public AuthorDto getById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public String deleteById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public int add(AuthorAddAndUpdateDto authorDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public AuthorDto update(int id, AuthorAddAndUpdateDto authorDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public ArrayList<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<AuthorDto> authors) {
        this.authors = authors;
    }
}
