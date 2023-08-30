package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController

/*
Request Mapping Ne işe yarar
HTTP GET isteklerini belirli bir yönlendirilmiş metoda (controller method) eşlemek için kullanılır. 
Yani bir Spring Controller'ında bu annotasyonu kullanarak, belirli bir URL yolu ile yapılan GET isteği,
ilgili metoda yönlendirilir ve metotun çalışmasını sağlar.
*/
@RequestMapping("api/test/") // localhosta 8080 yazdığımız zaman /api/test/ yazdığımız zaman çalışır halini görüyoruz.
public class TestController {

    @GetMapping(value="/")
    public String getMethodName() {
        return "Hello,World!";
    }

    // method tanımlama aşamaları ctrl + space ile method tanımlayabilirsin
    public void name() {
        
    }
    

}
