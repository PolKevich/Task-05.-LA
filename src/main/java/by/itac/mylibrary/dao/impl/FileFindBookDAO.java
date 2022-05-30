package by.itac.mylibrary.dao.impl;


import java.util.List;
import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.dao.repository.RepositoryBook;

public class FileFindBookDAO implements FindBookDAO {

	public Book find(int id) throws DAOException {
		RepositoryBook repositoryBook = RepositoryBook.getRepository();

		return repositoryBook.find(id);
	}

	public List<Book> findByTitle(String title) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Book> findByAuthor(String author) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
