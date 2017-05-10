package com.samgau.start.api;

import com.samgau.start.to.EmployeeDTO;

import java.util.List;

/**
 * Created by Tolegen Izbassar on 06.05.2017.
 */
public interface EmployeeService {

    EmployeeDTO findById(Long id);

    Long save(EmployeeDTO employee);

    boolean deleteById(Long id);

    EmployeeDTO findByEmail(String email);

    List<EmployeeDTO> getAll();
}
