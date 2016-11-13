package com.hudas.controllers;


import com.hudas.entities.Equipment;
import com.hudas.services.EquipmentService;
import com.hudas.services.EquipmentServiceImpl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

// ManagedBean bendrąją prasme - beans'as kurio gyvavimo ciklą valdo konteineris. (T.y. DI)

@Named(value = "maintenance") // CDI bean. Nurodžius name, galima naudot iš jsf kaip ir managed bean, todel managed nereikalingas
// @ManagedBean - JSF injection
// Stateful, Stateless - EJB injection
@RequestScoped
public class MaintenanceController {

    @Inject
    private EquipmentService equipmentService;


    private String message = "My controller works!";

    private Equipment equipment = new Equipment();


    public void maintain() {
        equipmentService.issueEquipment(equipment);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
