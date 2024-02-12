package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.scheduleexceptions.ScheduleNullException;
import com.uni_sabios.repository.RepositorySchedule;
import com.uni_sabios.repository.models.Schedule;
import com.uni_sabios.services.ServiceSchedule;

public class ServiceScheduleImpl implements ServiceSchedule{

    private final RepositorySchedule crudRepositorySchedule;

    public ServiceScheduleImpl(RepositorySchedule crudRepositorySchedule) {
        this.crudRepositorySchedule = crudRepositorySchedule;
    }

    @Override
    public List<Schedule> list() {
        return this.crudRepositorySchedule.list();
    }

    @Override
    public Schedule getSchedule(int scheduleId) throws ScheduleNullException {
        Schedule schedule = crudRepositorySchedule.getSchedule(scheduleId);
        if(schedule == null){
            throw new ScheduleNullException("Schedule not found");
        } else {
            return schedule;
        }
    }

    @Override
    public void create(Schedule schedule) {
        this.crudRepositorySchedule.create(schedule);
    }

    @Override
    public void modify(Schedule schedule) {
        this.crudRepositorySchedule.modify(schedule);
    }

    @Override
    public List<Schedule> listByStudentId(int studentId) {
        return this.crudRepositorySchedule.listByStudentId(studentId);
    }

    @Override
    public List<Schedule> listByTeacherId(int teacherId) {
        return this.crudRepositorySchedule.listByTeacherId(teacherId);
    }

    @Override
    public List<Schedule> listBySignatureId(int signatureId) {
        return this.crudRepositorySchedule.listBySignatureId(signatureId);
    }

    @Override
    public List<Schedule> listByClassroomId(int classroomId) {
        return this.crudRepositorySchedule.listByClassroomId(classroomId);
    }

    @Override
    public List<Schedule> listByDay(String day) {
        return this.crudRepositorySchedule.listByDay(day);
    }

    
    
}
