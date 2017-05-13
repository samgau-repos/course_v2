package com.samgau.start.repository.api;

import com.samgau.start.model.Department;

import java.util.List;

/**
 * Created by Tolegen Izbassar on 12.05.2017.
 */
public interface DepartmentRepository {

    List<Department> findAll();
}
