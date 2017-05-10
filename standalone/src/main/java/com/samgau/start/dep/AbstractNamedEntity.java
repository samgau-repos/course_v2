package com.samgau.start.dep;

import java.util.Date;

/**
 * Created by Tolegen Izbassar on 10.05.2017.
 */
public abstract class AbstractNamedEntity {

    private String name;
    private Date createDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
