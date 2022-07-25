package com.rumahorbo.app.structural.decorator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Silencer implements Weapon {

    private final Weapon weapon;

    @Override
    public String shootSound() {
        return weapon.shootSound() + " with silencer";
    }

}
