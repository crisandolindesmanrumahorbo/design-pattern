package com.rumahorbo.app.behavior.command;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Invoker {
    private final List<Command> commands;

    public List<String> execute() {
        List<String> responses = new ArrayList<>();
        for (Command command : commands) {
            responses.add(command.apiGetDetailCustomer());
        }
        return responses;
    }
}
