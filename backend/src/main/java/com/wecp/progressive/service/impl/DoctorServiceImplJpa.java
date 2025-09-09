package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Doctor;
import com.wecp.progressive.entity.Patient;
import com.wecp.progressive.exception.DoctorAlreadyExistsException;
import com.wecp.progressive.repository.DoctorRepository;
import com.wecp.progressive.service.DoctorService;

@Service
public class DoctorServiceImplJpa implements DoctorService{

    @Autowired
    private DoctorRepository dr;
    public DoctorServiceImplJpa(DoctorRepository dr){
        this.dr = dr;
    }
    @Override
    public List<Doctor> getAllDoctors() throws Exception {
        return dr.findAll();
    }

    @Override
    public Integer addDoctor(Doctor doctor) throws Exception {
        return dr.save(doctor).getDoctorId();
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() throws Exception {
        List<Doctor> sortedDoctors = dr.findAll();
        if(!sortedDoctors.isEmpty()){
            Collections.sort(sortedDoctors);
        }
        return sortedDoctors;

    }

    @Override
    public void updateDoctor(Doctor doctor) throws Exception { 
        Doctor oldDoctor = dr.findById(doctor.getDoctorId()).orElseThrow();
        oldDoctor.setFullName(doctor.getFullName());
        oldDoctor.setSpecialty(doctor.getSpecialty());
        oldDoctor.setContactNumber(doctor.getContactNumber());
        oldDoctor.setEmail(doctor.getEmail());
        oldDoctor.setYearsOfExperience(doctor.getYearsOfExperience());
        dr.save(oldDoctor);
    }

    @Override
    public void deleteDoctor(int doctorId) throws Exception {
        dr.deleteById(doctorId);
    }

    @Override
    public Doctor getDoctorById(int doctorId) throws Exception { 
        try{
            return dr.findById(doctorId).orElseThrow();
        } catch(Exception e){
            return null;
        }
    }

}