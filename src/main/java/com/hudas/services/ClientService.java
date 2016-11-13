package com.hudas.services;

import com.hudas.entities.Client;
import com.hudas.interceptors.Audit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.SynchronizationType;
import java.io.Serializable;

/**
 * Created by Ignas on 2016-11-06.
 */

@Stateless
public class ClientService implements Serializable {

    @PersistenceContext
    private EntityManager em;

    @Audit
    public void createClient(Client client) {
        System.out.println("CLIENT SERVICE: creating client!");
        System.out.println("CLIENT SERVICE: em:!" + em.toString());
        em.persist(client);
        // Would contain all business logic considering client creation.
    }
}
