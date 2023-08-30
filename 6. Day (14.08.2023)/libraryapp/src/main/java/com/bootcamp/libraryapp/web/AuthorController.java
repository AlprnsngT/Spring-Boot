package com.bootcamp.libraryapp.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.libraryapp.models.dto.AuthorDto;
import com.bootcamp.libraryapp.service.AuthorService;

@RestController
@RequestMapping("api/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping(value = "")
    public ResponseEntity<ArrayList<AuthorDto>> getAll() {
        return ResponseEntity.ok(authorService.getAll());
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
        return ResponseEntity.ok(authorService.deleteById(id));
    }

}
