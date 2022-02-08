package com.crud.questions.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.questions.models.Employee;
import com.crud.questions.service.EmployeeServiceInterface;


@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<Employee> Object = service.findById(id);
		if(Object.isPresent()) {
			ResponseEntity.notFound().build(); 
		}
		return ResponseEntity.ok(Object);
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Employee employee){
		Employee employeeBD = service.save(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeBD);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Employee employee , @PathVariable Long id){
		Optional<Employee> Object = service.findById(id);
		
		if(Object.isPresent() == false) {
			ResponseEntity.notFound().build();
		}
		Employee employeeBD = Object.get();
		employeeBD.setname(employee.getname());
		employeeBD.setLastname(employee.getLastname());
		employeeBD.setId(employee.getId());
		employeeBD.setEmail(employee.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(employeeBD));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
