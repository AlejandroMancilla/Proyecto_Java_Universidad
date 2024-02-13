package com.uni_sabios.repository.models;

import lombok.Data;

import com.uni_sabios.exceptions.classroomexceptions.ClassroomNullException;
import com.uni_sabios.exceptions.subjectexceptions.SubjectNullException;
import com.uni_sabios.repository.impl.RepositoryClassroomMysqlImpl;
import com.uni_sabios.repository.impl.RepositorySubjectMysqlImpl;
import com.uni_sabios.services.ServiceClassroom;
import com.uni_sabios.services.ServiceSubject;
import com.uni_sabios.services.impl.ServiceClassroomImpl;
import com.uni_sabios.services.impl.ServiceSubjectImpl;

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

    public static final ServiceSubject serviceSubject = new ServiceSubjectImpl(new RepositorySubjectMysqlImpl());
    public static final ServiceClassroom serviceClassroom = new ServiceClassroomImpl(new RepositoryClassroomMysqlImpl());

    public Schedule(String day, String start, String end, int classroomId, int signatureId) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.classroomId = classroomId;
        this.signatureId = signatureId;
    }

    public void print() throws SubjectNullException, ClassroomNullException {
        System.out.printf("|%-6s|%-12s|%-15s|%-15s|%-15s|%-40s|\n", getId(), getDay(), getStart(), getEnd(), serviceClassroom.getClassroom(getClassroomId()).getName(), serviceSubject.getSubject(getSignatureId()).getName());
        System.out.println("+" + "-".repeat(6) + "+" + "-".repeat(12) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(40) + "+");
    }

}