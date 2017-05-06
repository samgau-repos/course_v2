package com.samgau.start.repository.api;

import com.samgau.start.model.Employee;

import java.util.List;

/**
 * Created by Tolegen Izbassar on 03.05.2017.
 */
public interface EmployeeRepository {

    Employee findById(Long id);

    Long save(Employee employee);

    boolean deleteById(Long id);

    Employee findByEmail(String email);

    List<Employee> findAll();
}
