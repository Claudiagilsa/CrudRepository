package com.crud.questions.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.questions.models.Employee;

public interface EmployeeRepositoryInterface extends CrudRepository<Employee, Long>{

}
