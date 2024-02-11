package com.uni_sabios.repository.models;

public class Student extends Person{

    private int program;

    public Student(int typeId, String id, String name, String lastName, String phone, String date, int gender, int city, String address, int program) {
        super();
        this.program = program;
    }

}
