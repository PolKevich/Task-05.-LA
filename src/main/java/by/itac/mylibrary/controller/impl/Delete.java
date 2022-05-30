package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;


public class Delete implements Command {
    @Override
    public String execute(String request) {
        String response;
        String commandName;

        char paramDelimeter = ' ';
        commandName = request.substring(0,request.indexOf(paramDelimeter));

        Book book = new Book();
        book.setTitle(commandName);

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        BookService bookService = serviceProvider.getBookService();

        try {
            int id = Integer.parseInt(request.substring(request.indexOf(paramDelimeter)+1));
            book.setId(id);
            bookService.save(book);
            response = "Book removed!";
        } catch (ServiceException e) {
            response = "Error while deleting book!";
        }
        return response;
    }
}
