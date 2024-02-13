package com.uni_sabios.repository.models;

import com.uni_sabios.exceptions.periodexceptions.PeriodNullException;
import com.uni_sabios.exceptions.personexceptions.PersonNullException;
import com.uni_sabios.exceptions.subjectexceptions.SubjectNullException;
import com.uni_sabios.repository.impl.RepositoryPeriodMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryPersonMysqlImpl;
import com.uni_sabios.repository.impl.RepositorySubjectMysqlImpl;
import com.uni_sabios.services.ServicePeriod;
import com.uni_sabios.services.ServicePerson;
import com.uni_sabios.services.ServiceSubject;
import com.uni_sabios.services.impl.ServicePeriodImpl;
import com.uni_sabios.services.impl.ServicePersonImpl;
import com.uni_sabios.services.impl.ServiceSubjectImpl;

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

    public static final ServicePerson servicePerson = new ServicePersonImpl(new RepositoryPersonMysqlImpl());
    public static final ServiceSubject serviceSubject = new ServiceSubjectImpl(new RepositorySubjectMysqlImpl());
    public static final ServicePeriod servicePeriod = new ServicePeriodImpl(new RepositoryPeriodMysqlImpl());

    public Register(int studentId, int periodId, int subjectId) {
        this.studentId = studentId;
        this.periodId = periodId;
        this.subjectId = subjectId;
    }

    public void print() throws PersonNullException, SubjectNullException, PeriodNullException {
        System.out.printf("|%-6s|%-30s|%-8s|%-40s|\n", getId(), servicePerson.findById(getStudentId()).getFullName(), servicePeriod.getPeriod(getPeriodId()).getCode(), serviceSubject.getSubject(getSubjectId()).getName());
        System.out.println("+" + "-".repeat(6) + "+" + "-".repeat(30) + "+" + "-".repeat(8) + "+" + "-".repeat(40) + "+");
    }
}
