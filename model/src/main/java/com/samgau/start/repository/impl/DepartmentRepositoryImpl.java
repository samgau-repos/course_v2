package com.samgau.start.repository.impl;

import com.samgau.start.model.Department;
import com.samgau.start.repository.api.DepartmentRepositoryLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Tolegen Izbassar on 12.05.2017.
 */
@Stateless
public class DepartmentRepositoryImpl implements DepartmentRepositoryLocal {

    @PersistenceContext(unitName = "model-unit")
    private EntityManager entityManager;

    @Override
    public List<Department> findAll() {
        return entityManager
                .createQuery("SELECT dep FROM Department dep " +
                        "ORDER BY dep.name", Department.class)
                .getResultList();
    }
}
