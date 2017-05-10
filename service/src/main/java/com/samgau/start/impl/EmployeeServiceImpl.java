package com.samgau.start.impl;

import com.samgau.start.api.EmployeeServiceLocal;
import com.samgau.start.api.EmployeeServiceRemote;
import com.samgau.start.model.Employee;
import com.samgau.start.repository.api.EmployeeRepository;
import com.samgau.start.repository.api.EmployeeRepositoryRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by Tolegen Izbassar on 06.05.2017.
 */
@Stateless
public class EmployeeServiceImpl implements EmployeeServiceLocal,
        EmployeeServiceRemote {

    @EJB(beanInterface = EmployeeRepositoryRemote.class)
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Long save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public boolean deleteById(Long id) {
        return employeeRepository.deleteById(id);
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}
