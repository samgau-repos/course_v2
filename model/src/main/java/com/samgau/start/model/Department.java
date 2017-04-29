package com.samgau.start.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Tolegen Izbassar on 29.04.2017.
 */
@Entity
public class Department {

    @Id
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
