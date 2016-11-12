package com.hudas.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ignas on 2016-11-06.
 */

@Entity
public class Client {

    @Id
    @SequenceGenerator(name="client_generator", sequenceName="client_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="client_generator")
    private long id;

    @Column // by default should map by attribute name
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "client_id") // Valid since JPA 2.0
    private List<Service> services = new ArrayList<Service>();

    public Client(String name) {
        this.name = name;
    }

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void addService(Service service) {
        this.services.add(service);
    }
}
