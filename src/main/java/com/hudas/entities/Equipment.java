package com.hudas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ignas on 2016-11-06.
 */

@Entity
public class Equipment {

    @Id
    private long id;

    @Column
    private String model;

    public Equipment(String model) {
        this.model = model;
    }

    public Equipment() {
    }

    public String getModel() {
        return model;
    }
}
