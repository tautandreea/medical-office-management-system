package com.cabinetmedical.doctorservice.specialization.infrastructure;

import com.cabinetmedical.doctorservice.specialization.domain.Specialization;
import com.cabinetmedical.doctorservice.specialization.domain.daocontracts.ISpecializationDAO;
import com.cabinetmedical.doctorservice.specialization.infrastructure.tableEntities.SpecializationTableEntity;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SpecializationDAO
        implements ISpecializationDAO {

    private final SpecializationRepository specializationRepository;

    public SpecializationDAO(
            SpecializationRepository specializationRepository
    ) {
        this.specializationRepository =
                specializationRepository;
    }

    @Override
    public List<Specialization> findAll() {

        return specializationRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public Specialization findById(int id) {

        Optional<SpecializationTableEntity> entity =
                specializationRepository.findById(id);

        return entity
                .map(this::mapToDomain)
                .orElse(null);
    }

    @Override
    public Specialization findByName(String name) {

        Optional<SpecializationTableEntity> entity =
                specializationRepository.findByNameIgnoreCase(name);

        return entity
                .map(this::mapToDomain)
                .orElse(null);
    }

    @Override
    public boolean insert(
            Specialization specialization
    ) {

        try {

            specializationRepository.save(
                    mapToTableEntity(specialization)
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    private Specialization mapToDomain(
            SpecializationTableEntity entity
    ) {

        return new Specialization(
                entity.getSpecializationId(),
                entity.getName(),
                entity.getDescription()
        );
    }

    private SpecializationTableEntity mapToTableEntity(
            Specialization specialization
    ) {

        return new SpecializationTableEntity(
                specialization.getSpecializationId(),
                specialization.getName(),
                specialization.getDescription()
        );
    }
}