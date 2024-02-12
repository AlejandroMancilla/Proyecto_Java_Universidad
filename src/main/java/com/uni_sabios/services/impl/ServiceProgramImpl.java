package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.programexceptions.ProgramNullException;
import com.uni_sabios.repository.RepositoryProgram;
import com.uni_sabios.repository.models.Program;
import com.uni_sabios.services.ServiceProgram;

public class ServiceProgramImpl implements ServiceProgram{

    private final RepositoryProgram crudRepositoryProgram;

    public ServiceProgramImpl(RepositoryProgram crudRepositoryProgram) {
        this.crudRepositoryProgram = crudRepositoryProgram;
    }

    @Override
    public List<Program> list() {
        return this.crudRepositoryProgram.list();
    }

    @Override
    public Program getProgram(int programId) throws ProgramNullException {
        Program program = this.crudRepositoryProgram.getProgram(programId);
        if(program != null){
            return program;
        }else{
            throw new ProgramNullException("No program found with this id was found");
        }
    }

    @Override
    public void create(Program program) {
        this.crudRepositoryProgram.create(program);
    }

    @Override
    public void modify(Program program) {
        this.crudRepositoryProgram.modify(program);
    }

    @Override
    public void delete(Program program) {
        this.crudRepositoryProgram.delete(program);
    }
    
}
