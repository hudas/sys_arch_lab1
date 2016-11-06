package com.hudas.controllers;


import com.hudas.services.ActivationService;
import com.hudas.services.BillingService;
import com.hudas.services.ClientService;
import com.hudas.services.EquipmentService;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

// ManagedBean bendrąją prasme - beans'as kurio gyvavimo ciklą valdo konteineris. (T.y. DI)

@Named(value = "sale") // CDI bean. Nurodžius name, galima naudot iš jsf kaip ir managed bean, todel managed nereikalingas
// @ManagedBean - JSF injection
// Stateful, Stateless - EJB injection
@ConversationScoped
public class SaleController implements Serializable {

    private String message = "Conversation scope controller!";



    @Inject
    private ActivationService activationService;

    @Inject
    private BillingService billingService;

    @Inject
    private ClientService clientService;

    @Inject
    private EquipmentService equipmentService;

    public void createClient() {
        System.out.println("CONVERSATION: Creating client!");
    }

    public void activateBilling() {
        System.out.println("CONVERSATION: Activating Billing!");
    }

    public void issueEquipment() {
        System.out.println("CONVERSATION: Issue Equipment!");
    }

    public void activeServices() {
        System.out.println("CONVERSATION: Acvivate Service!");
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
