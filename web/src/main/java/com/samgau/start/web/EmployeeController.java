package com.samgau.start.web;

import com.samgau.start.api.EmployeeService;
import com.samgau.start.api.EmployeeServiceRemote;
import com.samgau.start.impl.DictionariesHolder;
import com.samgau.start.to.DepartmentDTO;
import com.samgau.start.to.EmployeeDTO;
import com.samgau.start.web.utils.JsfUtils;
import org.primefaces.event.RowEditEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by Tolegen Izbassar on 10.05.2017.
 */
@ManagedBean
@ViewScoped
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
        Long id = employeeService.save(employee);
        employee.setId(id);
        employeeDTOList.add(getCopy(employee));
        JsfUtils.addSuccessMessage("Сотрудник добавлне");
    }

    public void updateEmployee(RowEditEvent event) {
        EmployeeDTO employeeDTO = (EmployeeDTO) event.getObject();
        employeeService.save(employeeDTO);
        JsfUtils.addSuccessMessage("Сотрудник обновлен");
    }

    public List<DepartmentDTO> getDepartments() {
        return holder.getDepartmentDTOList();
    }

    public void prepareAdd() {
        employee = new EmployeeDTO();
    }

    private EmployeeDTO getCopy(EmployeeDTO employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setSkype(employee.getSkype());
        employeeDTO.setName(employee.getName());
        employeeDTO.setDepartmentId(employee.getDepartmentId());
        employeeDTO.setId(employee.getId());
        employeeDTO.setEmail(employee.getEmail());

        return employeeDTO;
    }
}
