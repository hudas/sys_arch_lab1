package com.hudas.services;

import com.hudas.entities.Equipment;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Created by Ignas on 2016-11-06.
 */

@Stateless
public class EquipmentServiceImpl implements Serializable {

    @PersistenceContext
    private EntityManager em;

    @Inject
    Event<Equipment> equipmentEvent;

    public void issueEquipment(Equipment equipment) {
        System.out.println("EQUIPMENT SERVICE: issuing equipment");

        // Fires event, to warehouse that equipment was issued
        equipmentEvent.fire(equipment);

        em.persist(equipment);
    }
}
