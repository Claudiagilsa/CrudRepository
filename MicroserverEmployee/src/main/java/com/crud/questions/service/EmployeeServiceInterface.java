package com.crud.questions.service;


import org.springframework.data.repository.CrudRepository;

import com.crud.questions.models.Employee;

public interface EmployeeServiceInterface extends CrudRepository<Employee, Long>{

}
