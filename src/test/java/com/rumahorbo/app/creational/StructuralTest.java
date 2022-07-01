package com.rumahorbo.app.creational;

import com.rumahorbo.app.structural.adapter.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StructuralTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void getProductDetail_adapter() {
        Product[] products = {
                new GoldAdapter(new Gold("1 gr", "24k")),
                new GoldAdapter(new Gold("10 gr", "12k")),
                new SmartphoneAdapter(new Smartphone("black", "23x8x0.8")),
                new SmartphoneAdapter(new Smartphone("blue navy", "22x7.5x0.5")),
        };

        assertEquals("Gold with mass 1 gr. Nb: 24k", products[0].getDetailProduct());
        assertEquals("Gold with mass 10 gr. Nb: 12k", products[1].getDetailProduct());
        assertEquals("Smartphone with color black. Nb: 23x8x0.8", products[2].getDetailProduct());
        assertEquals("Smartphone with color blue navy. Nb: 22x7.5x0.5", products[3].getDetailProduct());
    }
}
