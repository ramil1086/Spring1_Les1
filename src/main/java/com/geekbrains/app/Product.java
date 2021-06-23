package com.geekbrains.app;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String title;
    private BigDecimal cost;

    public Product(int id, String title, BigDecimal coast) {
        this.id = id;
        this.title = title;
        this.cost = coast;
    }

    @Override
    public String toString() {
        return String.format("id = %d, Title = %s, cost =%s", id, title,cost);

    }

}
