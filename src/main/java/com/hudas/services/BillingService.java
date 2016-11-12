package com.hudas.services;

import com.hudas.entities.Client;
import com.hudas.entities.Service;
import com.hudas.interceptors.Audit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.SynchronizationType;
import java.io.Serializable;

/**
 * Created by Ignas on 2016-11-06.
 */

@Stateless // Būtina turėji EJB komponentą.
public class BillingService implements Serializable, BillingActivation {

    @PersistenceContext
    private EntityManager em;

    @Audit
    public void activateBills(Client client, Service service) {
        System.out.println("Billing Service: activates billing for client");

        client.addService(service);
        em.persist(client);
    }
}
