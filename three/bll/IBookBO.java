package bll;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.Book;

public interface IBookBO {
	public List<Book> searchBooksByTitle(String title);
}
