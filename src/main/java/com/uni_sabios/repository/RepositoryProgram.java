package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.repository.models.Program;

public interface RepositoryProgram {
    List<Program> list();

    Program getProgram(int programId);

    void create(Program program);

    void modify(Program program);

    void delete(Program program);
}
