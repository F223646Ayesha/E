package Testing;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import dal.BookDAO;
import dto.Book;

public class BookDAOTesting {

    static BookDAO bookDAO;

    @BeforeAll
    public static void setup() {
        bookDAO = new BookDAO();
    }

    @Test
    public void testSearchBooks() {
        List<Book> books = bookDAO.searchBooksByTitle("Baraf ke Bhoot");
        assertFalse(books.isEmpty(), "Books should be found");
    }

    @Test
    public void testSearchBooks_NotFound() {
        List<Book> books = bookDAO.searchBooksByTitle("Java");
        assertTrue(books.isEmpty(), "Books should not be found");
    }
}
