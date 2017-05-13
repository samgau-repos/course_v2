package com.samgau.start.repository.impl;

import com.samgau.start.common.exceptions.SystemDatabaseException;
import com.samgau.start.model.Employee;
import com.samgau.start.repository.api.EmployeeRepositoryLocal;
import com.samgau.start.repository.api.EmployeeRepositoryRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Tolegen Izbassar on 03.05.2017.
 */
@Stateless
@TransactionAttribute()
public class EmployeeRepositoryImpl implements EmployeeRepositoryLocal,
        EmployeeRepositoryRemote {

    private static final Logger logger = LoggerFactory
            .getLogger(EmployeeRepositoryImpl.class);

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
    public boolean deleteById(Long id) throws SystemDatabaseException {
        logger.debug("deleteById() - start: id = {}", id);
        Query query = entityManager
                .createQuery("DELETE FROM Employee e WHERE e.id = :EMPLOYEE_ID");
        query.setParameter("EMPLOYEE_ID", id);
        try {
             return query.executeUpdate() == 1;
        } catch (PersistenceException e) {
            logger.error("deleteById() - error for id: {}", id, e);
            throw new SystemDatabaseException();
        }
    }

    @Override
    public Employee findByEmail(String email) {
        return entityManager.createNamedQuery(Employee.FindByEmail.NAME, Employee.class)
                .setParameter(Employee.FindByEmail.EMAIL, email)
                .getSingleResult();
    }

    @Override
    public List<Employee> findAll() {
        logger.debug("findAll() - start");
        List<Employee> employees = entityManager
                .createQuery("SELECT emp FROM Employee emp", Employee.class)
                .getResultList();
        logger.debug("findAll() - end: result size = {}", employees.size());
        return employees;
    }
}
