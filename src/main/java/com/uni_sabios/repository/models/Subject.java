package com.uni_sabios.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    private int id;
    private int credits;
    private int capacity;
    private int duration;
    private String name;
    private int teacherId;
    private int courseId;
    private int periodId;

    public Subject(int credits, int capacity, int duration, String name, int teacherId, int courseId, int periodId) {
        this.credits = credits;
        this.capacity = capacity;
        this.duration = duration;
        this.name = name;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.periodId = periodId;
    }

    public void print() {
        System.out.println("-".repeat(30));
        System.out.println("\t    ID: " + getId());
        System.out.println("\t  Name: " + getName());
        System.out.println("\t Level: " + getCredits());
        System.out.println("\t Level: " + getCapacity());
        System.out.println("-".repeat(30));
    }

}
