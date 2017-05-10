package com.samgau.start.web;

import com.samgau.start.api.EmployeeService;
import com.samgau.start.api.EmployeeServiceRemote;
import com.samgau.start.to.EmployeeDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by Tolegen Izbassar on 10.05.2017.
 */
@ManagedBean
@ViewScoped
public class EmployeeController {

    private List<EmployeeDTO> employeeDTOList;

    @EJB(beanInterface = EmployeeServiceRemote.class)
    private EmployeeService employeeService;

    @PostConstruct
    public void init() {
        employeeDTOList = employeeService.getAll();
    }

    public List<EmployeeDTO> getEmployeeDTOList() {
        return employeeDTOList;
    }
}
