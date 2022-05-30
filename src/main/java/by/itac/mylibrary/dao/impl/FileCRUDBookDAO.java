package by.itac.mylibrary.dao.impl;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.dao.repository.RepositoryBook;


public class FileCRUDBookDAO implements CRUDBookDAO {


    public void save(Book book) throws DAOException {

        RepositoryBook repositoryBook = RepositoryBook.getRepository();

        repositoryBook.addRepositoryBook(book);

    }

    public void update(int id, Book book) throws DAOException {
        // TODO Auto-generated method stub

    }

    public void delete(Book book) throws DAOException {
        // TODO Auto-generated method stub

    }

    public void delete(int id) throws DAOException {

        RepositoryBook repositoryBook = RepositoryBook.getRepository();
        repositoryBook.delete(id);
    }

    public void updateStatus(int id, int newStatus) throws DAOException {
        // TODO Auto-generated method stub

    }

}
