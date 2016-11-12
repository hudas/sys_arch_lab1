package com.hudas.services;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;

import java.io.Serializable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Singleton
@Startup // Create bean until the startup of the application
// Kitos galimybės statefull - serveris sesijos metu naudoja tą patį objektą, todėl galima užtikrinti būseną
// singleton - serveris naudoja bendrą vieną.
public class ActivationService implements Serializable {

    @Asynchronous
    @Lock(LockType.WRITE) // Write - single access
    @AccessTimeout(unit = TimeUnit.SECONDS, value = 5) // Antra gija lauks, jeigu timeoutins gaus concurent access exception.
    public Future<String> activateServices() {
        System.out.println("ACTIVATION SERVICE: calls low level physical systems.");

        return new AsyncResult<String>("Activation completed");
    }

    @PostConstruct
    public void initService() {
        System.out.println("SERVICE - Getting resources.");
    }

    @PreDestroy
    public void clearResources() {
        System.out.println("SERVICE - Clearing resources.");
    }
}
