package com.rumahorbo.app.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public class User implements Subscriber {
    private final String name;
    private final List<String> notifications;

    public User(String name) {
        this.name = name;
        this.notifications = new ArrayList<>();
    }

    @Override
    public void updateNotification(String notification) {
        this.notifications.add(notification);
    }

    @Override
    public List<String> getNotifications() {
        return this.notifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return this.name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
