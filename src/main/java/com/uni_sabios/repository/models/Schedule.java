package com.uni_sabios.repository.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    
    private int id;
    private String day;
    private String start;
    private String end;
    private int classroomId;
    private int signatureId;

    public Schedule(String day, String start, String end, int classroomId, int signatureId) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.classroomId = classroomId;
        this.signatureId = signatureId;
    }

    public void print() {
        System.out.println("-".repeat(30));
        System.out.println("\t     ID: " + getId());
        System.out.println("\t   Name: " + getDay());
        System.out.println("\t  Level: " + getStart());
        System.out.println("\t  Level: " + getEnd());
        System.out.println("\t   Room: " + getClassroomId());
        System.out.println("\tSubject: " + getSignatureId());
        System.out.println("-".repeat(30));
    }

}