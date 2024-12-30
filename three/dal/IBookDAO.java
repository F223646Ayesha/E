package dal;

import java.util.List;

import dto.Book;

public interface IBookDAO {
	public List<Book> searchBooksByTitle(String title);
}
