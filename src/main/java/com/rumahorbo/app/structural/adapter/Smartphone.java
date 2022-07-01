package com.rumahorbo.app.structural.adapter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Smartphone {
    private final String color;
    private final String dimension;

    public String getDetailProduct() {
        return "Smartphone with color " + this.color + ". Nb: " + this.dimension;
    }
}
