package com.uni_sabios.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Department {
    
    private int id;
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public void print() {
        System.out.printf("|%5s|%20S|\n", getId(), getName());
        System.out.println("+" + "-".repeat(5) + "+" + "-".repeat(20)+ "+");
    }

}
