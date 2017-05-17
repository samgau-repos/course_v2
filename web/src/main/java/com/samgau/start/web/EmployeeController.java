package com.samgau.start.web;

import com.samgau.start.api.EmployeeService;
import com.samgau.start.api.EmployeeServiceRemote;
import com.samgau.start.impl.DictionariesHolder;
import com.samgau.start.to.DepartmentDTO;
import com.samgau.start.to.EmployeeDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by Tolegen Izbassar on 10.05.2017.
 */
@ManagedBean
@ViewScoped
@SessionScoped
public class EmployeeController {

    private EmployeeDTO employee = new EmployeeDTO();
    private List<EmployeeDTO> employeeDTOList;

    @EJB(beanInterface = EmployeeServiceRemote.class)
    private EmployeeService employeeService;

    @EJB
    private DictionariesHolder holder;

    @PostConstruct
    public void init() {
        employeeDTOList = employeeService.getAll();
    }

    public List<EmployeeDTO> getEmployeeDTOList() {
        return employeeDTOList;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public void addEmployee() {
        employeeService.save(employee);
        FacesMessage facesMessage =
                new FacesMessage("Успешно", "Сотрудник добавлен");
        FacesContext.getCurrentInstance()
                .addMessage(null, facesMessage);
    }

    public List<DepartmentDTO> getDepartments() {
        return holder.getDepartments();
    }

    public void prepareAdd() {
        employee = new EmployeeDTO();
    }
}
