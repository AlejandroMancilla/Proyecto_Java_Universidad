package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.repository.RepositoryBuilding;
import com.uni_sabios.repository.models.Building;
import com.uni_sabios.services.ServiceBuilding;

public class ServiceBuildingImpl implements ServiceBuilding {

    private final RepositoryBuilding crudRepositoryBuilding;
    
    public ServiceBuildingImpl(RepositoryBuilding crudRepositoryBuilding) {
        this.crudRepositoryBuilding = crudRepositoryBuilding;
    }

    public List<Building> list() {
        return crudRepositoryBuilding.list();
    }

    public Building getBuilding(int buildingId) {
        return crudRepositoryBuilding.getBuilding(buildingId);
    }

    public void create(Building building){
        crudRepositoryBuilding.create(building);
    }

    public void update(Building building){
        crudRepositoryBuilding.update(building);
    }
    
}
