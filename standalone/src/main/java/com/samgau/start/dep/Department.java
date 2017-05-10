package com.samgau.start.dep;

import java.io.Serializable;

/**
 * Created by Tolegen Izbassar on 10.05.2017.
 */
public class Department extends AbstractNamedEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
