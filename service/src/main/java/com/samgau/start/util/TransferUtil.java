package com.samgau.start.util;

import com.samgau.start.model.Department;
import com.samgau.start.model.Employee;
import com.samgau.start.to.DepartmentDTO;
import com.samgau.start.to.EmployeeDTO;

/**
 * Created by Tolegen Izbassar on 10.05.2017.
 */
public final class TransferUtil {

    private TransferUtil() {}

    public static EmployeeDTO getEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId(employee.getId());
        employeeDTO.setDepartmentId(employee.getDepartment().getId());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSkype(employee.getSkype());

        return employeeDTO;
    }

    public static Employee getEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        employee.setId(employeeDTO.getId());
        employee.setSkype(employeeDTO.getSkype());
        employee.setEmail(employeeDTO.getEmail());
        employee.setName(employeeDTO.getName());

        return employee;
    }

    public static DepartmentDTO getDepartmentDTO(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());

        return departmentDTO;
    }
}
