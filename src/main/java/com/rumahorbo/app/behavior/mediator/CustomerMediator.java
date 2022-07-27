package com.rumahorbo.app.behavior.mediator;

public class CustomerMediator implements Mediator {
    @Override
    public void notify(Participant participant) {
        if (!participant.isIndonesiaCitizenCheckBox()) {
            participant.setCitizen("Show field to fill country citizen");
        }
    }
}
