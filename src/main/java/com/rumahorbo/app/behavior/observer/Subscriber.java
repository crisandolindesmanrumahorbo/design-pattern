package com.rumahorbo.app.behavior.observer;

import java.util.List;

public interface Subscriber {

    void updateNotification(String notification);

    List<String> getNotifications();
}
