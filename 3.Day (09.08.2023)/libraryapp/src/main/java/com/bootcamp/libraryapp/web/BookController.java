package com.bootcamp.libraryapp.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.libraryapp.model.entities.Book;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

/*
 * f5 yaptığında getmapping üzerinde ip ve localhostu yazar
 */

@RestController
@RequestMapping("api/books") // url kısmına bu yazılır.

public class BookController {

    @GetMapping(value = "/") // bu kısma da erişmek istediğimiz fonksiyonlar için özel kodlar yazıyoruz
    public boolean getMethodName() {
        return true;
    }

    @GetMapping(value = "getAll")
    public ArrayList<String> getMethodName1() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("namk");
        list.add("üsük");
        return list;
    }

    @GetMapping(value = "{id}")
    public String getMethodName(@RequestParam int id) {
        return "ID = --- " + id;
    }

    @PostMapping(value = "add")
    public boolean postMethodName(@RequestBody ArrayList<Book> entity) { // parametre olarak tanımladığımız classı
                                                                         // alıyoruz
        // TODO: process POST request

        return true;
    }

    @PutMapping(value = "add/{id}")
    public boolean putMethodName(@PathVariable int id) {
        // TODO: process PUT request
        return true;
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteMethodName(@PathVariable Book entity) {
        return true;
    }

    @PatchMapping("/patch/{id}")
    public int patchMethodName(@RequestBody int id) {
        id = 5;
        return id;
    }

}
