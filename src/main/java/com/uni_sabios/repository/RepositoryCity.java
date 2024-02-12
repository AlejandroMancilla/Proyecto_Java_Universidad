package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.repository.models.City;

public interface RepositoryCity {
    
    List<City> toList();

    City findByName(String name);

    void create(City city);

    void update(City city);

    void delete(City city);

}