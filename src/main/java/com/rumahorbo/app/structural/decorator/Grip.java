package com.rumahorbo.app.structural.decorator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Grip implements Weapon {
    private final Weapon weapon;

    @Override
    public String shootSound() {
        return weapon.shootSound() + " but with grip";
    }


}
