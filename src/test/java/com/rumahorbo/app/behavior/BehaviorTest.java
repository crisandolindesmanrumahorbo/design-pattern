package com.rumahorbo.app.behavior;

import com.rumahorbo.app.behavior.command.*;
import com.rumahorbo.app.behavior.mediator.Customer;
import com.rumahorbo.app.behavior.mediator.CustomerMediator;
import com.rumahorbo.app.behavior.mediator.Mediator;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class BehaviorTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void getCustomerIdentity_command_pattern() {
        String nik = "1200123124125125";
        Api customerApi = new CustomerApi();
        CustomerIdentityParamApi customerIdentityParamApi = new CustomerIdentityParamApi(nik);
        Command customerIdentityCommand = new CustomerIdentityCommand(customerApi, customerIdentityParamApi);
        Invoker invoker = new Invoker(Collections.singletonList(customerIdentityCommand));

        List<String> responses = invoker.execute();

        assertEquals(1, responses.size());
        assertEquals("Get customer identity from server with nik: " + nik, responses.get(0));
    }

    @Test
    public void getCustomerIdentityAndGetCustomerAccounts_command_pattern() {
        String nik = "1200123124125125";
        String cif = "1001VP";
        Api customerApi = new CustomerApi();
        CustomerIdentityParamApi customerIdentityParamApi = new CustomerIdentityParamApi(nik);
        CustomerAccountParamApi customerAccountParamApi = new CustomerAccountParamApi(cif);
        Command customerIdentityCommand = new CustomerIdentityCommand(customerApi, customerIdentityParamApi);
        Command customerAccountsCommand = new CustomerAccountCommand(customerApi, customerAccountParamApi);
        Invoker invoker = new Invoker(Arrays.asList(customerIdentityCommand, customerAccountsCommand));

        List<String> responses = invoker.execute();

        assertEquals(2, responses.size());
        assertEquals("Get customer identity from server with nik: " + nik, responses.get(0));
        assertEquals("Get customer accounts from server with cif: " + cif, responses.get(1));
    }

    @Test
    public void getCitizen_mediator_pattern() {
        boolean isIndonesiaCitizen = true;
        Mediator customerMediator = new CustomerMediator();
        Customer customerParticipant = new Customer(customerMediator, isIndonesiaCitizen);

        customerParticipant.validateCheckBoxCountry();
        String actualCitizen = customerParticipant.getCitizen();

        assertEquals(actualCitizen, "Indonesia");
    }

    @Test
    public void getOtherCountryCitizen_mediator_pattern() {
        boolean isIndonesiaCitizen = false;
        Mediator customerMediator = new CustomerMediator();
        Customer customerParticipant = new Customer(customerMediator, isIndonesiaCitizen);

        customerParticipant.validateCheckBoxCountry();
        String actualCitizen = customerParticipant.getCitizen();

        assertEquals(actualCitizen, "Show field to fill country citizen");
    }

}
