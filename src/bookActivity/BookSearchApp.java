package bookActivity;

import javax.swing.JTextField;

import dto.Book;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class BookSearchApp extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField searchField;
    private JButton searchButton;
    private JTextArea textArea;
    
    private static final String URL = "jdbc:mysql://localhost:3306/bookdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";
	public BookSearchApp() {
		setTitle("Book Search Application");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		JLabel label = new JLabel("Search for a book by title: ");
		topPanel.add(label);
		searchField = new JTextField(20);
		topPanel.add(searchField);
		searchButton = new JButton("Search");
		topPanel.add(searchButton);
		add(topPanel,BorderLayout.NORTH);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		add(scroll,BorderLayout.CENTER);
		
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					searchBooks();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
		setVisible((true));
	}
	private void searchBooks() throws RemoteException {
		
		String title = searchField.getText();
		 textArea.setText("Searching...");
		    Thread thread = new Thread(() -> {
		    	try {
					List<Book> books = searchBooksByTitle(title);
					textArea.setText("");
					if(books.isEmpty())
					{
						textArea.setText("No Books Found.");
					}
					else
					{
						for (Book book : books) {
							textArea.setText(book.toString() + "\n");
						}
					}
				
				} catch (Exception e) {
					e.printStackTrace();
				}
		 
		    });
		    thread.start();
} 	
	private List<Book> searchBooksByTitle(String title) {
		List<Book> books = new ArrayList<>();
		String query = "Select * FROM books Where title Like ?";
		try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
		PreparedStatement stmt = conn.prepareStatement(query)){
			stmt.setString(1,title);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				String bookTitle = rs.getString("title");
				String author = rs.getString("author");
				int year = rs.getInt("year");
				books.add(new Book(bookTitle,author,year));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	class Book
	{
		private String title;
		private String author;
		private int year;
		public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
		}
		@Override
		public String toString()
		{
			return title + " by " + author + "(" + year + ")";
			
		}
	}
	public static void main(String[] args) {
		new BookSearchApp();
	}
}
