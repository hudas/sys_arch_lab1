package com.hudas.controllers;


import com.hudas.entities.Client;
import com.hudas.entities.Equipment;
import com.hudas.entities.Service;
import com.hudas.services.*;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

// ManagedBean bendrąją prasme - beans'as kurio gyvavimo ciklą valdo konteineris. (T.y. DI)

@Named(value = "sale") // CDI bean. Nurodžius name, galima naudot iš jsf kaip ir managed bean, todel managed nereikalingas
// @ManagedBean - JSF injection
// Stateful, Stateless - EJB injection
@ConversationScoped
public class SaleController implements Serializable {

    private String message = "Conversation scope controller!";



    // Hack for demonstration - Entities should be filled by user forms.
    private Client client = new Client("Test");
    private Service service = new Service(new BigDecimal(5));
    private Equipment equipment = new Equipment();

    // @EJB Moka injectinti tik EJB kaskart sukuria nauja bean, tuo tarpu Inject - pilnas CDI injectinimas ir jis pirma ieško bean contexte
    @Inject
    private ActivationService activationService;

    @Inject
    private BillingActivation billingService;

    @Inject
    private ClientService clientService;

    @Inject
    private EquipmentServiceImpl equipmentService;

    public void createClient() {
        System.out.println("CONVERSATION: Creating client!");
        clientService.createClient(client);
    }

    public void activateBilling() {
        System.out.println("CONVERSATION: Activating Billing!");

        // Lets imagine that after submit request we get price from user filled form.
        billingService.activateBills(client, service);
    }

    public void issueEquipment() {
        System.out.println("CONVERSATION: Issue Equipment!");
        equipmentService.issueEquipment(equipment);
    }

    public void activeServices() {
        System.out.println("CONVERSATION: Acvivate Service!");
        Future<String> activation = activationService.activateServices();

        try {
            // Nelabai atskleidžiamas asinchroniškumas, nes po kvietimo nėra jokių kitų veiksmų, iškart laukiama future rezultato :)
            // Realiai galėtumėm atlikti tam tikrus veiksmus, arba mūsų atveju net nelaukti atsako.
            String status = activation.get();
        } catch (InterruptedException e) {
            // Some stuff
        } catch (ExecutionException e) {
            // Some stuff
        }
    }


    // Attribute Accesors
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
