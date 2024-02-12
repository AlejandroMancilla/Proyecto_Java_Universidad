package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.buildingexceptions.BuildingNullException;
import com.uni_sabios.repository.models.Building;

public interface ServiceBuilding {
    
    List<Building> list();

    Building getBuilding(int buildingId) throws BuildingNullException;

    void create(Building building);

    void update(Building building);

}
