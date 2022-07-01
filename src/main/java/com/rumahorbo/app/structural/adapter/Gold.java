package com.rumahorbo.app.structural.adapter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Gold {
    private final String mass;
    private final String pureGold;

    public String getDetailProduct() {
        return "Gold with mass " + this.mass + ". Nb: " + this.pureGold;
    }
}
