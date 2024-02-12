package com.uni_sabios.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Program {
    
    private int id;
    private String name;
    private String level;

    public Program(String name, String level){
        this.name = name;
        this.level = level;
    }

    public void print() {
        System.out.println("-".repeat(30));
        System.out.println("\t    ID: " + getId());
        System.out.println("\t  Name: " + getName());
        System.out.println("\t Level: " + getLevel());
        System.out.println("-".repeat(30));
    }

    
}
