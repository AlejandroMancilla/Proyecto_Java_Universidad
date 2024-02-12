package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.scheduleexceptions.ScheduleNullException;
import com.uni_sabios.repository.models.Schedule;

public interface ServiceSchedule {
    
    List<Schedule> list();

    Schedule getSchedule(int scheduleId) throws ScheduleNullException;

    void create(Schedule schedule);

    void modify(Schedule schedule);

    List<Schedule> listByStudentId(int studentId);

    List<Schedule> listByTeacherId(int teacherId);

    List<Schedule> listBySignatureId(int signatureId);

    List<Schedule> listByClassroomId(int classroomId);

    List<Schedule> listByDay(String day);

}
