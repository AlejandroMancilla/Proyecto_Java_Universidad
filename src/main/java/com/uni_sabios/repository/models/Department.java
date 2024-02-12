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
        System.out.println("-".repeat(30));
        System.out.println("\t    ID: " + getId());
        System.out.println("\t  Name: " + getName());
        System.out.println("-".repeat(30));
    }

}
