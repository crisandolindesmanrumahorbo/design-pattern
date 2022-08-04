package com.rumahorbo.app.behavior.observer;

import java.util.List;

public class YoutubeChannel implements Publisher {
    private final String name;
    private final List<Subscriber> subscribers;

    public YoutubeChannel(String name, List<Subscriber> subscribers) {
        this.name = name;
        this.subscribers = subscribers;
    }

    @Override
    public void notifySubscribers(String videoTitle) {
        for (Subscriber subscriber : this.subscribers) {
            String notification = this.name + " upload new video with title " + videoTitle;
            subscriber.updateNotification(notification);

        }
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void unSubscribe(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    @Override
    public void uploadVideo(String videoTitle) {
        notifySubscribers(videoTitle);
    }

}
