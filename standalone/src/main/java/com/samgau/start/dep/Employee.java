package com.samgau.start.dep;

import java.io.Serializable;

/**
 * Created by Tolegen Izbassar on 10.05.2017.
 */
public class Employee extends AbstractNamedEntity implements Serializable {

    private Long id;

    private String email;

    private String skype;

    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
