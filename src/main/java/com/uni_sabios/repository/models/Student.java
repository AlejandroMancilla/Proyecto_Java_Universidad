package com.uni_sabios.repository.models;

import lombok.Data;

import com.uni_sabios.exceptions.programexceptions.ProgramNullException;
import com.uni_sabios.repository.impl.RepositoryPersonMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryProgramMysqlImpl;
import com.uni_sabios.services.ServicePerson;
import com.uni_sabios.services.ServiceProgram;
import com.uni_sabios.services.impl.ServicePersonImpl;
import com.uni_sabios.services.impl.ServiceProgramImpl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student{
  
    private int id;
    private int programId;
    private int personId;
    

    public Student(int programId, int personId) {
        this.programId = programId;
        this.personId = personId;
    }

}
