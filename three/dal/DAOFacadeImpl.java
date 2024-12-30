package dal;

import java.util.List;

import dto.Book;

public class DAOFacadeImpl implements DAOFacade{
	IBookDAO bookDAO;
	public DAOFacadeImpl(IBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public List<Book> searchBooksByTitle(String title) {
		return bookDAO.searchBooksByTitle(title);
	}

}
