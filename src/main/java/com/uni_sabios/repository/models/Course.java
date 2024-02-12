package com.uni_sabios.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    
    private int id;
    private String name;
    private String guideDoc;

    public Course(String name, String guideDoc) {
        this.name = name;
        this.guideDoc = guideDoc;
    }

    public void print() {
        System.out.printf("|%5s|%40s|\n", getId(), getName());
        System.out.println("+" + "-".repeat(5) + "+" + "-".repeat(40)+ "+");
    }
}
