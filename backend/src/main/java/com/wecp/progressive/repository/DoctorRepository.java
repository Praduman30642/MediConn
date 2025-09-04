package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Doctor;
import java.util.List;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
    List<Doctor> findByEmail(String email);
}
