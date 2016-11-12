package com.hudas.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Ignas on 2016-11-06.
 */
@Entity
public class Service {

    @Id // H2 BUG? Default allocation size somehow does not work :) In postgres never had any issues
    @SequenceGenerator(name="service_generator", sequenceName="service_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="service_generator")
    private long id;

    private BigDecimal price;

    public Service(BigDecimal price) {
        this.price = price;
    }

    public Service() {
    }

    public BigDecimal getPrice() {
        return price;
    }
}
