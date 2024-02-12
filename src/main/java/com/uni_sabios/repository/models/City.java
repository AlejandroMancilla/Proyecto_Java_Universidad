package com.uni_sabios.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class City {
    
    private int id;
    private String name;

    public City(String name) {
        this.name = name;
    }

}