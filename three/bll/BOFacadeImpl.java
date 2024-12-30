package bll;

import java.util.List;

import dto.Book;

public class BOFacadeImpl implements BOFacade{
	IBookBO bookBO;
	public BOFacadeImpl(IBookBO bookBO) {
		this.bookBO=bookBO;
	}
	public List<Book> searchBooksByTitle(String title)
	{
		return bookBO.searchBooksByTitle(title);
		
	}
}
