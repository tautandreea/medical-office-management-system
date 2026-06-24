package com.cabinetmedical.doctorservice.specialization.controllers;

import com.cabinetmedical.doctorservice.specialization.domain.Specialization;
import com.cabinetmedical.doctorservice.specialization.domain.dto.CreateSpecializationDTO;
import com.cabinetmedical.doctorservice.specialization.services.SpecializationService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specializations")
public class SpecializationController {

    private final SpecializationService specializationService;

    public SpecializationController(
            SpecializationService specializationService
    ) {
        this.specializationService =
                specializationService;
    }

    @GetMapping
    public List<Specialization> getAll() {

        return specializationService
                .getAllSpecializations();
    }

    @GetMapping("/{id}")
    public Specialization getById(
            @PathVariable int id
    ) {

        return specializationService
                .getSpecializationById(id);
    }

    @GetMapping("/name/{name}")
    public Specialization getByName(
            @PathVariable String name
    ) {

        return specializationService
                .getSpecializationByName(name);
    }

    @PostMapping
    public boolean create(
            @RequestBody CreateSpecializationDTO dto
    ) {

        return specializationService
                .createSpecialization(dto);
    }
}