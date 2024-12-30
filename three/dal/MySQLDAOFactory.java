package dal;

public class MySQLDAOFactory extends AbstractDAOFactory{
	
	@Override
    public IBookDAO createBookDAO()
    {
    	return new BookDAO();
    }
}
