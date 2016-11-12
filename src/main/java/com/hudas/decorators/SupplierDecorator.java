package com.hudas.decorators;

import com.hudas.entities.Equipment;
import com.hudas.services.EquipmentService;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * Created by Ignas on 2016-11-12.
 */
@Decorator
public class SupplierDecorator implements EquipmentService {


    @Inject
    @Delegate
    EquipmentService equipmentService;

    @Any
    public void issueEquipment(Equipment equipment) {
        equipmentService.issueEquipment(equipment);

        // Handles notification to supplier warehouse that equipment was used and new must be sent
    }
}
