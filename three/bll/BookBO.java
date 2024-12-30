package bll;

import java.util.List;

import dal.DAOFacade;
import dto.Book;

public class BookBO implements IBookBO{
	DAOFacade bookDAO;
	public BookBO(DAOFacade bookDAO) {
		this.bookDAO= bookDAO;
	}
	@Override
	public List<Book> searchBooksByTitle(String title)
	{
		return bookDAO.searchBooksByTitle(title);
		
	}
}
