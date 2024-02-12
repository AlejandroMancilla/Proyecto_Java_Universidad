package com.uni_sabios.repository.models;

import com.uni_sabios.exceptions.programexceptions.ProgramNullException;
import com.uni_sabios.exceptions.studentexceptions.StudentNullException;
import com.uni_sabios.repository.impl.RepositoryDepartmentMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryProgramMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryStudentMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryTeacherMysqlImpl;
import com.uni_sabios.services.ServiceDepartment;
import com.uni_sabios.services.ServiceProgram;
import com.uni_sabios.services.ServiceStudent;
import com.uni_sabios.services.ServiceTeacher;
import com.uni_sabios.services.impl.ServiceDepartmentImpl;
import com.uni_sabios.services.impl.ServiceProgramImpl;
import com.uni_sabios.services.impl.ServiceStudentImpl;
import com.uni_sabios.services.impl.ServiceTeacherImpl;

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
    private String gender;
    private int cityResidence;
    private int addressId;
    public static final ServiceProgram serviceProgram = new ServiceProgramImpl(new RepositoryProgramMysqlImpl());
    public static final ServiceStudent serviceStudent = new ServiceStudentImpl(new RepositoryStudentMysqlImpl());
    public static final ServiceTeacher serviceTeacher = new ServiceTeacherImpl(new RepositoryTeacherMysqlImpl());
    public static final ServiceDepartment serviceDepartment = new ServiceDepartmentImpl(new RepositoryDepartmentMysqlImpl());

    public Person(String typeId, String numId, String name, String lastName, String phoneNumber, String dateBirth,
            String gender, int cityResidence, int address) {
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

    public void print() throws ProgramNullException, StudentNullException{
        Student s = serviceStudent.findbyId(getId());
        Program p = serviceProgram.getProgram(s.getProgramId());
        System.out.printf("|%-5s|%-15s|%-30s|%-15s|%-15s|%-30s|\n", getTypeId(), getId(), getFullName(), getPhoneNumber(), getDateBirth(), p.getName());
        System.out.println("+" + "-".repeat(5) + "+" + "-".repeat(15) + "+" + "-".repeat(30) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(30) + "+");
    }
}


