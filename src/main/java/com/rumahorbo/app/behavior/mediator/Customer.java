package com.rumahorbo.app.behavior.mediator;


public class Customer implements Participant {

    private final Mediator customerMediator;
    private final boolean indonesiaCitizenCheckBox;
    private String citizen = "Indonesia";

    public Customer(Mediator customerMediator, boolean indonesiaCitizenCheckBox) {
        this.customerMediator = customerMediator;
        this.indonesiaCitizenCheckBox = indonesiaCitizenCheckBox;
    }

    public void validateCheckBoxCountry() {
        customerMediator.notify(this);
    }

    public String getCitizen() {
        return citizen;
    }

    @Override
    public void setCitizen(String citizen) {
        this.citizen = citizen;
    }

    @Override
    public boolean isIndonesiaCitizenCheckBox() {
        return this.indonesiaCitizenCheckBox;
    }
}
