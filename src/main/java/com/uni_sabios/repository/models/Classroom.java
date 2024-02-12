package com.uni_sabios.repository.models;

import lombok.Data;

import com.uni_sabios.exceptions.buildingexceptions.BuildingNullException;
import com.uni_sabios.repository.impl.RepositoryBuildingMysqlImpl;
import com.uni_sabios.services.ServiceBuilding;
import com.uni_sabios.services.impl.ServiceBuildingImpl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {

    private static final ServiceBuilding serviceBuilding = new ServiceBuildingImpl(new RepositoryBuildingMysqlImpl());
    
    private int id;
    private int capacity;
    private int level;
    private String name;
    private int buildingId;

    public Classroom(int capacity, int level, String name, int buildingId) {
        this.capacity = capacity;
        this.level = level;
        this.name = name;
        this.buildingId = buildingId;
    }

    public void print() throws BuildingNullException {
        System.out.printf("|%-5s|%-8s|%-30s|%-10s|%-10s|\n", getId(), getName(), serviceBuilding.getBuilding(getBuildingId()).getName(), getLevel(), getCapacity());
        System.out.println("+" + "-".repeat(5) + "+" + "-".repeat(8) + "+" + "-".repeat(30) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+");
    }

}