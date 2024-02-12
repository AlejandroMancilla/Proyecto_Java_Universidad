package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.repository.models.City;

public interface ServiceCity {
    
    List<City> toList();
    
    City findByName(String name);

    void create(City city);
    
    void update(City city);

}