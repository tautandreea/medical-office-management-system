package com.cabinetmedical.doctorservice.schedule.domain.daocontracts;

import com.cabinetmedical.doctorservice.schedule.domain.Schedule;

import java.util.List;

public interface IScheduleDAO {

    List<Schedule> findAll();

    Schedule findById(int id);

    List<Schedule> findByDoctorId(int doctorId);

    boolean insert(Schedule schedule);

    boolean update(Schedule schedule);

    boolean delete(int id);
}