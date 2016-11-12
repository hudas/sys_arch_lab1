package com.hudas.services;

import com.hudas.entities.Equipment;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

/**
 * Created by Ignas on 2016-11-08.
 */

@Stateless
public class WarehouseService {

    public void retrieveEquipment(@Observes Equipment equipment) {
        System.out.println("WAREHOUSE SERVICE: Equipment retrieved from warehouse");

    }
}
