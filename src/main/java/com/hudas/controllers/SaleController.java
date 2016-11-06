package com.hudas.controllers;


import javax.annotation.ManagedBean;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

// ManagedBean bendrąją prasme - beans'as kurio gyvavimo ciklą valdo konteineris. (T.y. DI)

@Named(value = "sale") // CDI bean. Nurodžius name, galima naudot iš jsf kaip ir managed bean, todel managed nereikalingas
// @ManagedBean - JSF injection
// Stateful, Stateless - EJB injection
@ConversationScoped
public class SaleController implements Serializable {

    private String message = "My controller works!";


    public void createClient() {
        System.out.println("Creating client!");
    }

    public void activateBilling() {

    }

    public void issueEquipment() {

    }

    public void activeServices() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
