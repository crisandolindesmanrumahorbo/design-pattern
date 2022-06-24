package com.rumahorbo.app.creational.singleton;

public class SingletonService {
    private static SingletonService instance;
    private final String name;

    private SingletonService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SingletonService getInstance(String name) {
        if (instance == null) {
            instance = new SingletonService(name);
        }
        return instance;
    }
}
