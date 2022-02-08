package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alumno;

public interface AlumnoInterfaceRepository extends CrudRepository<Alumno, Long> {
	
	

}
