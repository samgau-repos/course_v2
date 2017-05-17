package com.samgau.start.impl;

import com.samgau.start.api.EmployeeServiceLocal;
import com.samgau.start.api.EmployeeServiceRemote;
import com.samgau.start.util.TransferUtil;
import com.samgau.start.model.Employee;
import com.samgau.start.repository.api.EmployeeRepository;
import com.samgau.start.repository.api.EmployeeRepositoryRemote;
import com.samgau.start.to.EmployeeDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tolegen Izbassar on 06.05.2017.
 */
@Stateless
public class EmployeeServiceImpl implements EmployeeServiceLocal,
        EmployeeServiceRemote {

    @EJB(beanInterface = EmployeeRepositoryRemote.class)
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id);
        return TransferUtil.getEmployeeDTO(employee);
    }

    @Override
    public Long save(EmployeeDTO employee) {
        return employeeRepository.save(TransferUtil.getEmployee(employee));
    }

    @Override
    public boolean deleteById(Long id) {
        return employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO findByEmail(String email) {
        return TransferUtil.getEmployeeDTO(employeeRepository.findByEmail(email));
    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<EmployeeDTO> list = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            EmployeeDTO employeeDTO = TransferUtil.getEmployeeDTO(employee);
            list.add(employeeDTO);
        }
        return list;
    }
}
