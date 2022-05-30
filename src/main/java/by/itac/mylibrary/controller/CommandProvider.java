package by.itac.mylibrary.controller;

import by.itac.mylibrary.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {

    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider(){
        repository.put(CommandName.CHANGETOREAD, new ChangeToRead());
        repository.put(CommandName.FINDBYID, new FindByID());
        repository.put(CommandName.SAVE, new Save());
        repository.put(CommandName.DELETE, new Delete());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name){
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);

        } catch (IllegalArgumentException | NullPointerException e){
            command = repository.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }
}
