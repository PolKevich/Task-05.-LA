package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.Command;

public class WrongRequest implements Command {
    @Override
    public String execute(String request) {
        String response = "Something went wrong!";

        return response;
    }
}
