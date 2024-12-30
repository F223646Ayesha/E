package pl;

import javax.swing.JTextField;

import bll.BOFacade;
import bll.BookBO;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import dto.Book;
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
    BOFacade bookBO;
  
	public BookSearchApp(BOFacade bookBO) {
		this.bookBO = bookBO;
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
				searchBooks();
				
			}

			private void searchBooks() {
				
					String title = searchField.getText();
					List<Book> books = bookBO.searchBooksByTitle(title);
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
				
			}});
		setVisible((true));
	}	
}

