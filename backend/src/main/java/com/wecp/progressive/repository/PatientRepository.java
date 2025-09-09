package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

    
}
