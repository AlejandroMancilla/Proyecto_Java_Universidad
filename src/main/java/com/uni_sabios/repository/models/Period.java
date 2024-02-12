package com.uni_sabios.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Period {
    
    private int id;
    private String year;
    private String semester;
    private String code;

    public Period(String year, String semester, String code) {
        this.year = year;
        this.semester = semester;
        this.code = code;
    }

    public void print(){
        System.out.printf("|%-5s|%-8s|%-8s|%-8s|\n", getId(), getYear().substring(0,4), getSemester(), getCode());
        System.out.println("+" + "-".repeat(5) + "+" + "-".repeat(8)+ "+" + "-".repeat(8) + "+" + "-".repeat(8)+ "+");
    }

}