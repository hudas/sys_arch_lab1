package com.hudas.services;

import com.hudas.entities.Client;
import com.hudas.entities.Service;

/**
 * Created by Ignas on 2016-11-06.
 */
public interface BillingActivation {
    void activateBills(Client client, Service service);
}
