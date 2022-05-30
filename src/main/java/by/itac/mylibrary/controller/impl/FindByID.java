package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;


public class FindByID implements Command {
    @Override
    public String execute(String request) {
        Book book;
        String response;
        String commandName;

        char paramDelimeter = ' ';
        commandName = request.substring(request.indexOf(paramDelimeter) + 1);

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        BookService bookService = serviceProvider.getBookService();

        try {
            int id = Integer.parseInt(commandName);
            book = bookService.findByID(id);
            if (book != null) {
                response = book.toString();
            } else response = "No book requested!";
        } catch (ServiceException e) {
            response = "Error when searching for a book!";
        }
        return response;
    }
}
