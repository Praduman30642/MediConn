package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Appointment;
import java.util.List;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

    // public List<Appointment> findByClinicId(Integer clinicId);
    // public List<Appointment> findByPatientId(Integer patientId);
    public List<Appointment> findByStatus(String status);

}
