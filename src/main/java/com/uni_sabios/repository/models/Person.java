package com.uni_sabios.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    private int id;
    private int typeId;
    private String numId;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String dateBirth;
    private int gender;
    private int cityResidence;
    private String address;

    public Person(int typeId, String numId, String name, String lastName, String phoneNumber, String dateBirth,
            int gender, int cityResidence, String address) {
        this.typeId = typeId;
        this.numId = numId;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateBirth = dateBirth;
        this.gender = gender;
        this.cityResidence = cityResidence;
        this.address = address;
    }

    public String getFullName() {
        return this.name + " " + this.lastName;
    }

}


