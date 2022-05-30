package by.itac.mylibrary.service;


import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.exception.ServiceException;


public interface BookService {
	
	void save(Book book) throws ServiceException;
	Book findByID(int id) throws ServiceException;

}
