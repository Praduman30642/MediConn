package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Doctor;
import com.wecp.progressive.service.impl.DoctorServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorServiceImplJpa ds;
    public DoctorController(DoctorServiceImplJpa ds) {
        this.ds = ds;
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() throws Exception {
        return new ResponseEntity<>(ds.getAllDoctors(), HttpStatus.OK);
    }

    @GetMapping("/{doctorID}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int doctorId) throws Exception{
        return new ResponseEntity<>(ds.getDoctorById(doctorId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> addDoctor(@RequestBody Doctor doctor) throws Exception {
        return new ResponseEntity<>(ds.addDoctor(doctor), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) throws Exception {
        ds.updateDoctor(doctor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable int id) throws Exception {
        ds.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<List<Doctor>> getDoctorSortedByExperience() throws Exception {
        return ResponseEntity.ok(ds.getDoctorSortedByExperience());
    }
}
