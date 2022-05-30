package by.itac.mylibrary.service.impl;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.DAOProvider;
import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.exception.ServiceException;


public class BookServiceImpl implements BookService {

    public void save(Book book) throws ServiceException {

        if (book.getTitle().equals("delete")) {

            int id = book.getId();
            if (id == 0 || id < 0) {
                throw new ServiceException("Invalid paramaters!");
            }
            try {
                DAOProvider provider = DAOProvider.getInstance();
                CRUDBookDAO dao = provider.getBookDAO();
                dao.delete(id);
            } catch (DAOException e) {
                throw new ServiceException(e);
            }

        } else if (book == null || book.getTitle().isEmpty()) {
            throw new ServiceException("Book not created!");

        } else {
            try {
                DAOProvider provider = DAOProvider.getInstance();
                CRUDBookDAO dao = provider.getBookDAO();
                dao.save(book);

            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }

    }

    public Book findByID(int id) throws ServiceException {

        Book book;
        if (id == 0 || id < 0) {
            throw new ServiceException("Invalid paramaters!");
        }
        try {
            DAOProvider provider = DAOProvider.getInstance();
            FindBookDAO dao = provider.getFindDAO();
            book = dao.find(id);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return book;
    }

}
