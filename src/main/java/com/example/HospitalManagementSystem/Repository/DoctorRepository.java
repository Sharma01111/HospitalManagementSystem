package com.example.HospitalManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HospitalManagementSystem.User.Doctor;
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}