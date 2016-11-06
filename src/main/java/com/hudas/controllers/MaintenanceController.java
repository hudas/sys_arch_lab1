package com.hudas.controllers;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

// ManagedBean bendrąją prasme - beans'as kurio gyvavimo ciklą valdo konteineris. (T.y. DI)

@Named(value = "maintenance") // CDI bean. Nurodžius name, galima naudot iš jsf kaip ir managed bean, todel managed nereikalingas
// @ManagedBean - JSF injection
// Stateful, Stateless - EJB injection
@RequestScoped // Poto pakeisti i conversation
public class MaintenanceController {

    private String message = "My controller works!";



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
