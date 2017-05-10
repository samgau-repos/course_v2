package com.samgau.start.repository.impl;

import com.samgau.start.model.Employee;
import com.samgau.start.repository.api.EmployeeRepositoryLocal;
import com.samgau.start.repository.api.EmployeeRepositoryRemote;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Tolegen Izbassar on 03.05.2017.
 */
@Stateless
@TransactionAttribute()
public class EmployeeRepositoryImpl implements EmployeeRepositoryLocal,
        EmployeeRepositoryRemote {

    @PersistenceContext(unitName = "model-unit")
    private EntityManager entityManager;

    @Override
    public Employee findById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Long save(Employee employee) {
        if (employee.getId() == null) {
            entityManager.persist(employee);
        } else {
            entityManager.merge(employee);
        }
        return employee.getId();
    }

    @Override
    public boolean deleteById(Long id) {
        Query query = entityManager
                .createQuery("DELETE FROM Employee e WHERE e.id = :EMPLOYEE_ID");
        query.setParameter("EMPLOYEE_ID", id);
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public Employee findByEmail(String email) {
        return entityManager.createNamedQuery(Employee.FindByEmail.NAME, Employee.class)
                .setParameter(Employee.FindByEmail.EMAIL, email)
                .getSingleResult();
    }

    @Override
    public List<Employee> findAll() {
        return entityManager
                .createQuery("SELECT emp FROM Employee emp", Employee.class)
                .getResultList();
    }
}
