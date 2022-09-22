package com.example.HospitalManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.HospitalManagementSystem.Exception.UserNotFoundException;
import com.example.HospitalManagementSystem.Service.DoctorService;
import com.example.HospitalManagementSystem.User.Doctor;



@RestController
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@RequestMapping("/Doctor")
	public List<Doctor> getAllDoctor()
	{
		List<Doctor> doctor = doctorService.getAllDoctor();
		
		if(doctor.size() <= 0)
			throw new UserNotFoundException("Doctor details are not available, please update first.");
			
	  return doctor;
	}
	
	@GetMapping("/Doctor/{id}/")
	public Doctor getDoctor(@PathVariable Integer id)
	{
		Doctor doctor = doctorService.getDoctor(id);
		
		if(doctor ==  null)
			throw new UserNotFoundException("Doctor ID are not present");
			
	  return doctor;
	}
	
	
	@RequestMapping(method =RequestMethod.POST , value="/Doctor" )
	public void addDoctor(@RequestBody Doctor doctor)
	{
		Doctor doc = doctorService.getDoctor(doctor.getId());
		
		if(doc !=null)
		{
			throw new UserNotFoundException("Doctor ID are already present");
		}
		
		doctorService.addDoctor(doctor);
	}
	@RequestMapping(method =RequestMethod.PUT , value="/Doctor/{id}/salary/{salary}" )
	public void updateDoctor(@PathVariable Integer id, @PathVariable Double salary)
	{
		doctorService.updateDoctor(id, salary);
		
	}
	@RequestMapping(method =RequestMethod.DELETE , value="/Doctor/{id}" )
	public void DeleteDoctor(@PathVariable Integer id)
	{
		doctorService.deleteDoctor(id);
	}
}