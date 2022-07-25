package com.rumahorbo.app.structural;

import com.rumahorbo.app.structural.adapter.*;
import com.rumahorbo.app.structural.composite.*;
import com.rumahorbo.app.structural.decorator.AK47;
import com.rumahorbo.app.structural.decorator.Grip;
import com.rumahorbo.app.structural.decorator.Silencer;
import com.rumahorbo.app.structural.decorator.Weapon;
import com.rumahorbo.app.structural.facade.Notification;
import com.rumahorbo.app.structural.facade.NotificationType;
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

    @Test
    public void getSalaries_composite() {
        Developer developer = new Developer();
        Developer developer1 = new Developer();
        ProductOwner productOwner = new ProductOwner(new Developer[]{developer1, developer});
        ScrumMaster scrumMaster = new ScrumMaster();
        CoreCircle coreCircle = new CoreCircle(new Manager[]{productOwner, scrumMaster});

        int cosSalesSalariesEmployee = coreCircle.getServiceTotalSalary();

        assertEquals(50, cosSalesSalariesEmployee);
    }

    @Test
    public void getResponse_facade() {
        Notification notificationSMS = new Notification("08123", NotificationType.SMS);
        Notification notificationCall = new Notification("08123", NotificationType.CALL);

        String actualResponseSMS = notificationSMS.notificationResponse().getMessage();
        String actualResponseCall = notificationCall.notificationResponse().getMessage();

        assertEquals(actualResponseSMS, "SMS to 08123 is sending");
        assertEquals(actualResponseCall, "Call on processing to 08123");
    }

    @Test
    public void shoot_withGrip_decorator() {
        Weapon AK47 = new AK47();
        Weapon gripAK47 = new Grip(AK47);

        String actualShootSound = gripAK47.shootSound();

        assertEquals("takk takk but with grip", actualShootSound);
    }

    @Test
    public void shoot_withGripAndSilencer_decorator() {
        Weapon AK47 = new AK47();
        Weapon gripAK47 = new Grip(AK47);
        Weapon silencerGripAK47 = new Silencer(gripAK47);

        String actualShootSound = silencerGripAK47.shootSound();

        assertEquals("takk takk but with grip with silencer", actualShootSound);
    }

    @Test
    public void shoot_withSilencer_decorator() {
        Weapon AK47 = new AK47();
        Weapon silencerAK47 = new Silencer(AK47);

        String actualShootSound = silencerAK47.shootSound();

        assertEquals("takk takk with silencer", actualShootSound);
    }
}
