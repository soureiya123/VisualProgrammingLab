package com.example.fourthsemester;

import java.math.BigDecimal;

public class OrderListModel {


    String name;
   BigDecimal price;
    BigDecimal weight;

    public OrderListModel(String name, BigDecimal weight, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
