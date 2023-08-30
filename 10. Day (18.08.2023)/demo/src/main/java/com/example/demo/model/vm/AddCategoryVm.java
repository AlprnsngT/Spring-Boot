package com.example.demo.model.vm;

import jakarta.validation.constraints.NotBlank;

public class AddCategoryVm {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    

    
}
