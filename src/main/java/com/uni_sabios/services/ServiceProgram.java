package com.uni_sabios.services;

import java.util.List;
import com.uni_sabios.exceptions.programexceptions.ProgramNullException;
import com.uni_sabios.repository.models.Program;

public interface ServiceProgram {
    List<Program> list();

    Program getProgram(int programId) throws ProgramNullException;

    void create(Program program);

    void modify(Program program);

    void delete(Program program);

}
