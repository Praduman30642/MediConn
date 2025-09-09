package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Clinic;
import com.wecp.progressive.service.impl.ClinicServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clinic")
public class ClinicController {
    @Autowired
    ClinicServiceImplJpa clinicServiceImplJpa;
    @GetMapping
    public ResponseEntity<List<Clinic>> getAllClinics() {
        List<Clinic> list = clinicServiceImplJpa.getAllClinics();
        if (list != null) {
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.status(500).build();
    }
    @GetMapping("/{clinicId}")
    public ResponseEntity<Clinic> getClinicById(@PathVariable int clinicId) {
        Clinic c = clinicServiceImplJpa.getClinicById(clinicId);
        if(c != null){
            return ResponseEntity.ok(c);
        }
        return ResponseEntity.status(500).build();
    }
    @PostMapping
    public ResponseEntity<Integer> addClinic(Clinic clinic) {
        try {
            return ResponseEntity.status(201).body(clinicServiceImplJpa.addClinic(clinic));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    @PutMapping("/{clinicId}")
    public ResponseEntity<Void> updateClinic(int clinicId, Clinic clinic) {
        try {
            clinicServiceImplJpa.updateClinic(clinic);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    @DeleteMapping("/{clincId}")
    public ResponseEntity<Void> deleteClinic(int clinicId) {
        try {
            clinicServiceImplJpa.deleteClinic(clinicId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping("/location/{location}")
    public ResponseEntity<List<Clinic>> getAllClinicByLocation(@PathVariable String location) {
        try {
            return ResponseEntity.ok(clinicServiceImplJpa.getAllClinicByLocation(location));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    public ResponseEntity<List<Clinic>> getAllClinicByDoctorId(int doctorId) {
        return null;
    }
}