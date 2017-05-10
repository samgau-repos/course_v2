package com.samgau.start.api;

import com.samgau.start.model.Employee;

/**
 * Created by Tolegen Izbassar on 06.05.2017.
 */
public interface EmployeeService {

    Employee findById(Long id);

    Long save(Employee employee);

    boolean deleteById(Long id);

    Employee findByEmail(String email);
}
