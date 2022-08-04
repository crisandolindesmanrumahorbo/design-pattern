package com.rumahorbo.app.behavior;

import com.rumahorbo.app.behavior.command.*;
import com.rumahorbo.app.behavior.iterator.Array;
import com.rumahorbo.app.behavior.iterator.Iterator;
import com.rumahorbo.app.behavior.mediator.Customer;
import com.rumahorbo.app.behavior.mediator.CustomerMediator;
import com.rumahorbo.app.behavior.mediator.Mediator;
import com.rumahorbo.app.behavior.observer.Publisher;
import com.rumahorbo.app.behavior.observer.Subscriber;
import com.rumahorbo.app.behavior.observer.User;
import com.rumahorbo.app.behavior.observer.YoutubeChannel;
import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void forwardIterator_iterator_pattern() {
        boolean isBackward = false;
        int[] numbers = {5, 1, 5, 2, 3, 8, 2};
        Array array = new Array(isBackward, numbers);
        Iterator forwardIterator = array.createIterator();
        int i = 0;

        while (forwardIterator.hasNext()) {
            assertEquals(numbers[i], forwardIterator.next());
            i++;
        }
    }

    @Test
    public void backwardIterator_iterator_pattern() {
        boolean isBackward = true;
        int[] numbers = {5, 1, 5, 2, 3, 8, 2};
        Array array = new Array(isBackward, numbers);
        Iterator backward = array.createIterator();
        int i = numbers.length - 1;

        while (backward.hasNext()) {
            assertEquals(numbers[i], backward.next());
            i--;
        }
    }

    @Test
    public void uploadVideo_observer_pattern() {
        Subscriber chandler = new User("chandler");
        Subscriber chris = new User("chris");
        Publisher publisher = new YoutubeChannel("MrBeast", Arrays.asList(chandler, chris));

        publisher.uploadVideo("Give away $1000000");

        assertEquals(chandler.getNotifications().size(), 1);
        assertEquals(chris.getNotifications().size(), 1);
        assertEquals(chandler.getNotifications().get(0), "MrBeast upload new video with title Give away $1000000");
    }

    @Test
    public void subscribe_observer_pattern() {
        List<Subscriber> subscribers = new ArrayList<>();
        Subscriber chandler = new User("chandler");
        Subscriber chris = new User("chris");
        Subscriber nolan = new User("nolan");
        subscribers.add(chandler);
        subscribers.add(chris);
        Publisher publisher = new YoutubeChannel("MrBeast", subscribers);
        publisher.subscribe(nolan);

        publisher.uploadVideo("Give away $1000000");
        publisher.uploadVideo("Give away a House");

        assertEquals(chandler.getNotifications().size(), 2);
        assertEquals(chris.getNotifications().size(), 2);
        assertEquals(nolan.getNotifications().size(), 2);
        assertEquals(chandler.getNotifications().get(0), "MrBeast upload new video with title Give away $1000000");
        assertEquals(chris.getNotifications().get(0), "MrBeast upload new video with title Give away $1000000");
        assertEquals(nolan.getNotifications().get(1), "MrBeast upload new video with title Give away a House");
    }

    @Test
    public void unSubscribe_observer_pattern() {
        List<Subscriber> subscribers = new ArrayList<>();
        Subscriber chandler = new User("chandler");
        Subscriber chris = new User("chris");
        subscribers.add(chandler);
        subscribers.add(chris);
        Publisher publisher = new YoutubeChannel("MrBeast", subscribers);

        publisher.uploadVideo("Give away $1000000");
        publisher.unSubscribe(chris);
        publisher.uploadVideo("Give away a House");

        assertEquals(chandler.getNotifications().size(), 2);
        assertEquals(chris.getNotifications().size(), 1);
        assertEquals(chandler.getNotifications().get(1), "MrBeast upload new video with title Give away a House");
        assertEquals(chris.getNotifications().get(0), "MrBeast upload new video with title Give away $1000000");
    }

}
