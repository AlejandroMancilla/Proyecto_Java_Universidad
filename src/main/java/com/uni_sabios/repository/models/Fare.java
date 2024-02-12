package com.uni_sabios.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fare {
    
    private int id;
    private int creditValue;
    private int programId;
    private int periodId;

    public Fare(int creditValue, int programId, int periodId) {

        this.creditValue = creditValue;
        this.programId = programId;
        this.periodId = periodId;

    }

    public void print() {
        System.out.println("-".repeat(30));
        System.out.println("\t      ID: " + getId());
        System.out.println("\t Program: " + getProgramId());
        System.out.println("\t  Period: " + getPeriodId());
        System.out.println("\t   Value: " + getCreditValue());
        System.out.println("-".repeat(30));
    }

}