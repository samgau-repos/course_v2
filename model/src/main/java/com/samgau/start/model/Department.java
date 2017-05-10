package com.samgau.start.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

/**
 * Created by Tolegen Izbassar on 29.04.2017.
 */
@Entity
@SequenceGenerator(name = "DepartmentGenerator", sequenceName = "seq_d_department",
                    allocationSize = 1, initialValue = 50)
@Table(name = "d_department", uniqueConstraints = {
        @UniqueConstraint(name = "name_unique", columnNames = "name")
})
public class Department extends AbstractNamedEntity implements Serializable {

    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DepartmentGenerator")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Department that = (Department) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                "name=" + getName() +
                '}';
    }
}
