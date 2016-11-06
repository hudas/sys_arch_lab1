package com.hudas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by Ignas on 2016-11-06.
 */
@Entity
public class Service {

    @Id
    private long id;

    private BigDecimal price;

    public Service(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
