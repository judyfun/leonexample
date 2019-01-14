package com.com.leon.util.help;

import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;

import java.util.Optional;

/**
 * xuchuahao
 * on 2019/1/11.
 */
public class Modem {
    Double price;

    public Modem(double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPriceInRange(Modem modem) {
        boolean isInRange = false;
        if (modem != null && modem.getPrice() != null
                && modem.getPrice() > 10
                && modem.getPrice() < 30) {
            isInRange = true;
        }
        return isInRange;
    }

    public boolean isPriceInRange2(Modem modem) {
        return Optional.of(modem)
                .map(m -> m.getPrice())
                .filter(p -> p > 10)
                .filter(p -> p < 30)
                .isPresent();
    }
}
