package pl;

import bll.BOFacade;
import bll.BOFacadeImpl;
import bll.IBookBO;
import bll.BookBO;
import dal.DAOFacade;
import dal.DAOFacadeImpl;
import dal.AbstractDAOFactory;
import dal.IBookDAO;
import dal.IDAOFactory;
public class Main {
	public static void main(String[] args) {
		IDAOFactory daoFactory = AbstractDAOFactory.getInstance();
		IBookDAO bookDAO = daoFactory.createBookDAO();
		DAOFacade dFacade = new DAOFacadeImpl(bookDAO);
		IBookBO bookBO = new BookBO(dFacade);
		BOFacade bFacade = new BOFacadeImpl(bookBO);
		new BookSearchApp(bFacade);
	}
}
