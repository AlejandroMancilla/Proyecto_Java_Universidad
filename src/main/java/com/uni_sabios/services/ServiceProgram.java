package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.programexceptions.ProgramException;
import com.uni_sabios.repository.models.Program;

public interface ServiceProgram {
    List<Program> list();

    Program getProgram(String code) throws ProgramException;

    void create(Program program);

    void modify(Program program);

    void delete(Program program);
}
