package com.rumahorbo.app.structural.facade;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Notification {
    private String phoneNumber;
    private NotificationType notificationType;

    public Response notificationResponse() {
        switch (notificationType) {
            case SMS:
                return new Response("SMS to " + this.phoneNumber + " is sending");
            case CALL:
                return new Response("Call on processing to " + this.phoneNumber);
        }
        return new Response("Notification Method is not identified");
    }
}
