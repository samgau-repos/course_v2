package com.samgau.start.to;

import java.io.Serializable;

/**
 * Created by Tolegen Izbassar on 10.05.2017.
 */
public class DepartmentDTO implements Serializable {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
