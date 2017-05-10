package com.samgau.start.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Tolegen Izbassar on 29.04.2017.
 */
@Entity
@Table(name = "e_employee")
@SequenceGenerator(name = "EmployeeGenerator", allocationSize = 1,
        sequenceName = "seq_e_employee", initialValue = 100)
@NamedQueries({
        @NamedQuery(name = Employee.FindByEmail.NAME, query = Employee.FindByEmail.QUERY)
})
public class Employee extends AbstractNamedEntity implements Serializable {

    public final static class FindByEmail {
        public static final String EMAIL = "email";
        public static final String NAME = "Employee.FindByEmail";
        static final String QUERY = "SELECT e FROM Employee e WHERE e.email = :" + EMAIL;
    }

    private Long id;

    private String email;

    private String skype;

    private Department department;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EmployeeGenerator")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "em", nullable = false, length = 100)
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    @ManyToOne
    @JoinColumn(name = "d_department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Employee employee = (Employee) o;

        return getId() != null ? getId().equals(employee.getId()) : employee.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                '}';
    }
}
