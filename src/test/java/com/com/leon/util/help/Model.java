package com.com.leon.util.help;

/**
 * xuchuahao
 * on 2019/1/11.
 */
public class Model {
    Double price;

    public Model(double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPriceInRange(Model model) {
        boolean isInRange = false;
        if (model != null && model.getPrice() != null
                && model.getPrice() > 10
                && model.getPrice() < 30) {
              isInRange =true ;
        }
        return isInRange;
    }
}
