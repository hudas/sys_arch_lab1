package com.hudas.entities;

import javax.persistence.*;

/**
 * Created by Ignas on 2016-11-06.
 */

@Entity
public class Equipment {

    @Id
    @SequenceGenerator(name="equipment_generator", sequenceName="equipment_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="equipment_generator")
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
