package com.uni_sabios.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {
    
    private int id;
    private int studentId;
    private int periodId;
    private int subjectId;

    public Register(int studentId, int periodId, int subjectId) {
        this.studentId = studentId;
        this.periodId = periodId;
        this.subjectId = subjectId;
    }

    public void print() {
        System.out.println("-".repeat(30));
        System.out.println("\t    ID: " + getId());
        System.out.println("\t  Name: " + getStudentId());
        System.out.println("\t Level: " + getPeriodId());
        System.out.println("\t Level: " + getSubjectId());
        System.out.println("-".repeat(30));
    }

}
