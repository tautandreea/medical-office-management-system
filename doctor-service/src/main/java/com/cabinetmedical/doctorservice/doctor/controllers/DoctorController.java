package com.cabinetmedical.doctorservice.doctor.controllers;

import com.cabinetmedical.doctorservice.doctor.domain.Doctor;
import com.cabinetmedical.doctorservice.doctor.domain.dto.CreateDoctorDTO;
import com.cabinetmedical.doctorservice.doctor.domain.dto.UpdateDoctorDTO;
import com.cabinetmedical.doctorservice.doctor.services.DoctorService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(
            DoctorService doctorService
    ) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {

        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(
            @PathVariable int id
    ) {

        return doctorService.getDoctorById(id);
    }

    @GetMapping("/search")
    public List<Doctor> searchDoctorsByName(
            @RequestParam String name
    ) {

        return doctorService.searchDoctorsByName(name);
    }

    @GetMapping("/specialization/{specializationId}")
    public List<Doctor> getDoctorsBySpecialization(
            @PathVariable int specializationId
    ) {

        return doctorService.getDoctorsBySpecialization(
                specializationId
        );
    }

    @PostMapping
    public boolean createDoctor(
            @RequestBody CreateDoctorDTO dto
    ) {

        return doctorService.createDoctor(dto);
    }

    @PutMapping
    public boolean updateDoctor(
            @RequestBody UpdateDoctorDTO dto
    ) {

        return doctorService.updateDoctor(dto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteDoctor(
            @PathVariable int id
    ) {

        return doctorService.deleteDoctor(id);
    }
}