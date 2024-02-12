package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.repository.models.Building;

public interface RepositoryBuilding {

    List<Building> list();

    Building getBuilding(int buildingId);

    void create(Building building);

    void update(Building building);
    
}
