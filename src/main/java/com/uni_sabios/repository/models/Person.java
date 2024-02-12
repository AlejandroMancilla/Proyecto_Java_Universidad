package com.uni_sabios.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    private int id;
    private String typeId;
    private String numId;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String dateBirth;
    private int gender;
    private int cityResidence;
    private int addressId;

    public Person(String typeId, String numId, String name, String lastName, String phoneNumber, String dateBirth,
            int gender, int cityResidence, int address) {
        this.typeId = typeId;
        this.numId = numId;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateBirth = dateBirth;
        this.gender = gender;
        this.cityResidence = cityResidence;
        this.addressId = address;
    }

    public String getFullName() {
        return this.name + " " + this.lastName;
    }

    public void print() {
        System.out.println(this.typeId + " " + this.numId + " " + this.name + " " + this.lastName + " " + this.phoneNumber
                + " " + this.dateBirth + " " + this.gender + " " + this.cityResidence + " " + this.addressId);
    }

}


