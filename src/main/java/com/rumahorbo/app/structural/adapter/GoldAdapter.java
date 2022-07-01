package com.rumahorbo.app.structural.adapter;

public class GoldAdapter implements Product {
    private final Gold adaptee;

    public GoldAdapter(Gold gold) {
        this.adaptee = gold;
    }

    @Override
    public String getDetailProduct() {
        return adaptee.getDetailProduct();
    }
}
