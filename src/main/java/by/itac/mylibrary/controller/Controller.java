package by.itac.mylibrary.controller;

public final class Controller {

    private final CommandProvider commandProvider = new CommandProvider();

    public String executeTask(String request){
        String commandName;
        Command command;

        char paramDelimeter = ' ';
        commandName = request.substring(0,request.indexOf(paramDelimeter));
        command = commandProvider.getCommand(commandName);

        String response;
        response = command.execute(request);


        return response;
    }
}
