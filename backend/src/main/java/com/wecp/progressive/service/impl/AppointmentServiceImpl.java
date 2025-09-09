package com.wecp.progressive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Appointment;
import com.wecp.progressive.repository.AppointmentRepository;
import com.wecp.progressive.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{


    @Autowired
    private AppointmentRepository ar;
    
    @Override
    public List<Appointment> getAllAppointments() {
        return ar.findAll();
    }

    @Override
    public int createAppointment(Appointment appointment) {
        return ar.save(appointment).getAppointmentId();
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        Appointment oldAppointment = ar.findById(appointment.getAppointmentId()).orElseThrow();
        oldAppointment.setAppointmentDate(appointment.getAppointmentDate());
        oldAppointment.setClinic(appointment.getClinic());
        oldAppointment.setPatient(appointment.getPatient());
        oldAppointment.setPurpose(appointment.getPurpose());
        oldAppointment.setStatus(appointment.getStatus());
        ar.save(oldAppointment);
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        return ar.findById(appointmentId).orElseThrow();
    }

    @Override
    public List<Appointment> getAppointmentByClinic(int clinicId) {
        // return ar.findByClinicId(clinicId);
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAppointmentByClinic'");
    }

    @Override
    public List<Appointment> getAppointmentByPatient(int patientId) {
        // return ar.findByPatientId(patientId);
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAppointmentByPatient'");
    }

    @Override
    public List<Appointment> getAppointmentByStatus(String status) {
        return ar.findByStatus(status);
    }

}