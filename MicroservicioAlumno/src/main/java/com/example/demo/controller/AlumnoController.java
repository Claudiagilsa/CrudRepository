package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Alumno;
import com.example.demo.service.AlumnoInterfaceService;

@RestController
public class AlumnoController {
	
	@Autowired
	
	private AlumnoInterfaceService service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional <Alumno> a = service.findById(id);
		
		if(a.isEmpty()) {
			ResponseEntity.notFound();
		}
		return ResponseEntity.ok(a);
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Alumno alumno){
		Alumno estudiante=service.save(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(estudiante);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){
		
		Optional<Alumno> obj=service.findById(id);
		
		if(obj.isPresent()== false) {
			ResponseEntity.notFound().build();
		}
		
		Alumno estudiante= obj.get();
		estudiante.setId(estudiante.getId());
		estudiante.setName(estudiante.getName());
		estudiante.setLastname(estudiante.getLastname());
		estudiante.setAge(estudiante.getAge());
		estudiante.setPhone(estudiante.getPhone());
		estudiante.setEmail(estudiante.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(estudiante));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id){
		
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
