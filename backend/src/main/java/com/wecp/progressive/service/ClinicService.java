package com.wecp.progressive.service;

import com.wecp.progressive.entity.Clinic;

import java.util.List;

public interface ClinicService {

    public List<Clinic> getAllClinics() throws Exception;

    public Clinic getClinicById(int clinicId) throws Exception;

    public Integer addClinic(Clinic clinic) throws Exception;

    public void updateClinic(Clinic clinic) throws Exception;

    public void deleteClinic(int clinicId) throws Exception;

    //Do not implement these methods in ClinicServiceImplJdbc.java class
    public List<Clinic> getAllClinicByLocation(String location);

    public List<Clinic> getAllClinicByDoctorId(int doctorId);
}
