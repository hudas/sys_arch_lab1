package com.hudas.services;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
// Kitos galimybės statefull - serveris sesijos metu naudoja tą patį objektą, todėl galima užtikrinti būseną
// singleton - serveris naudoja bendrą vieną.
public class ActivationService implements Serializable {

    @PostConstruct
    public void initService() {
        System.out.println("SERVICE - Getting resources.");
    }

    @PreDestroy
    public void clearResources() {
        System.out.println("SERVICE - Clearing resources.");
    }
}
