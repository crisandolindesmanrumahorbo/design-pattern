package com.rumahorbo.app.structural.adapter;

public class SmartphoneAdapter implements Product {
    private final Smartphone adaptee;

    public SmartphoneAdapter(Smartphone smartphone) {
        this.adaptee = smartphone;
    }

    @Override
    public String getDetailProduct() {
        return adaptee.getDetailProduct();
    }
}
