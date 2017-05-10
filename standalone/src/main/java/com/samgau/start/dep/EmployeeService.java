package com.samgau.start.dep;

/**
 * Created by Tolegen Izbassar on 10.05.2017.
 */
public interface EmployeeService {

    Employee findById(Long id);

    Long save(Employee employee);

    boolean deleteById(Long id);

    Employee findByEmail(String email);
}
