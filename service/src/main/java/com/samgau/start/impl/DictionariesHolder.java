package com.samgau.start.impl;

import com.samgau.start.model.Department;
import com.samgau.start.repository.api.DepartmentRepository;
import com.samgau.start.repository.api.DepartmentRepositoryLocal;
import com.samgau.start.to.DepartmentDTO;
import com.samgau.start.util.TransferUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tolegen Izbassar on 12.05.2017.
 */
@Singleton
@Startup
public class DictionariesHolder {

    @EJB(beanInterface = DepartmentRepositoryLocal.class)
    private DepartmentRepository departmentRepository;

    private List<DepartmentDTO> departmentDTOList;
    private List<Department> departments;

    @PostConstruct
    public void init() {
        departments = departmentRepository.findAll();
        departmentDTOList = departments
                .stream().map(TransferUtil::getDepartmentDTO)
                .collect(Collectors.toList());
    }

    @Lock(LockType.READ)
    public List<DepartmentDTO> getDepartmentDTOList() {
            return departmentDTOList;
    }

    public Department getDepartmentById(Long departmentId) {
        return departments.stream()
                .filter(x -> x.getId().equals(departmentId))
                .findFirst().get();
    }
}
