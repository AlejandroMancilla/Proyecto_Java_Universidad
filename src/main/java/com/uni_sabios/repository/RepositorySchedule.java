package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.repository.models.Schedule;

public interface RepositorySchedule {
    List<Schedule> list();

    Schedule getSchedule(int scheduleId);

    void create(Schedule schedule);

    void modify(Schedule schedule);

    List<Schedule> listByStudentId(int studentId);

    List<Schedule> listByTeacherId(int teacherId);

    List<Schedule> listBySignatureId(int signatureId);

    List<Schedule> listByClassroomId(int classroomId);

    List<Schedule> listByDay(String day);
}
