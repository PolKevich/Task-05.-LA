package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;


public class Save implements Command {
    @Override
    public String execute(String request) {
        String response;

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        BookService bookService = serviceProvider.getBookService();

        int indexStartAuthor = request.indexOf('[') + 1;
        int indexEndAuthor = request.indexOf(']');
        String author = request.substring(indexStartAuthor, indexEndAuthor);

        int indexStartTitleBook = request.indexOf('{') + 1;
        int indexEndTitleBook = request.indexOf('}');
        String titleBook = request.substring(indexStartTitleBook, indexEndTitleBook);

        int indexStartYear = request.indexOf('-') + 2;
        String year = request.substring(indexStartYear);

        Book book = new Book(author,titleBook,year);
        try {
            bookService.save(book);
            response = "Book saved!";
        } catch (ServiceException e) {
            response = "Book saving error!";
        }
        return response;
    }
}
