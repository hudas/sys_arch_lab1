package com.hudas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ignas on 2016-11-06.
 */

@Entity
public class Client {

    @Id
    private long id;

    @Column // by default should map by attribute name
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public Client() {
    }

    public String getName() {
        return name;
    }
}
