package com.cabinetmedical.doctorservice.specialization.domain.daocontracts;

import com.cabinetmedical.doctorservice.specialization.domain.Specialization;

import java.util.List;

public interface ISpecializationDAO {

    List<Specialization> findAll();

    Specialization findById(int id);

    Specialization findByName(String name);

    boolean insert(Specialization specialization);
}