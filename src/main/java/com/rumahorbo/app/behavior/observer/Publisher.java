package com.rumahorbo.app.behavior.observer;

import java.util.List;

public interface Publisher {
    void notifySubscribers(String videoTitle);

    void subscribe(Subscriber subscriber);

    void unSubscribe(Subscriber subscriber);

    void uploadVideo(String videoTitle);
}
