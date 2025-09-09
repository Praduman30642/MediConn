package com.wecp.progressive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Clinic;
import com.wecp.progressive.exception.ClinicAlreadyExistsException;
import com.wecp.progressive.repository.ClinicRepository;
import com.wecp.progressive.repository.DoctorRepository;
import com.wecp.progressive.service.ClinicService;

@Service
public class ClinicServiceImplJpa implements ClinicService {

    private final DoctorRepository doctorRepository;

    @Autowired
    private ClinicRepository cr;
    public ClinicServiceImplJpa(ClinicRepository cr, DoctorRepository doctorRepository){
        this.cr = cr;
        this.doctorRepository = doctorRepository;
        
    }
    @Override
    public List<Clinic> getAllClinics() throws Exception {
        return cr.findAll();
    }

    @Override
    public Clinic getClinicById(int clinicId) throws Exception {
        try{
            return cr.findById(clinicId).orElseThrow();
        } catch(Exception e){
            return null;
        }
        
    }

    @Override
    public Integer addClinic(Clinic clinic) throws Exception {
        List<Clinic> res = cr.findByLocation(clinic.getLocation());
        if(res.size() > 0){
            throw new ClinicAlreadyExistsException();
        }
        return cr.save(clinic).getClinicId();
    }

    @Override
    public void updateClinic(Clinic clinic) throws Exception {
        Clinic oldClinic = cr.findById(clinic.getClinicId()).orElseThrow();
        oldClinic.setClinicName(clinic.getClinicName());
        oldClinic.setContactNumber(clinic.getContactNumber());
        oldClinic.setDoctorId(clinic.getDoctorId());
        oldClinic.setEstablishedYear(clinic.getEstablishedYear());
        oldClinic.setLocation(clinic.getLocation());
        cr.save(oldClinic);
    }

    @Override
    public void deleteClinic(int clinicId) throws Exception {
        cr.deleteById(clinicId);
    }
    @Override
    public List<Clinic> getAllClinicByLocation(String location) {
        return cr.findByLocation(location);
    }
    @Override
    public List<Clinic> getAllClinicByDoctorId(int doctorId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllClinicByDoctorId'");
    }

}