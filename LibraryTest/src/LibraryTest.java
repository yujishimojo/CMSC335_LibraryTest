import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LibraryTest implements ActionListener {

	//declare Swing components as instance variables
	static Library library;
	static JFrame outputFrame;
	static JPanel panel1, panel2, panel3;
	static Container container;
	static JLabel label1, label2, label3;
	static JTextField textField1, textField2, textField3;
	static JButton button1, button2, button3;
	static JTextArea textArea;

	public static void main(String args[]){
		// instantiate a Library object
		library  = new Library();

		// create instances of authors
		library.authors.add(new Author("Dan Brown", "123 Street", "Concord", "New Hampshire", 3301, "603-123-456"));
		library.authors.add(new Author("Stephen R. Covey", "456 Street", "Salt Lake City", "Utah", 84101, "385-456-7890"));
		library.authors.add(new Author("Tina Seelig", "450 Serra Mall", "Stanford", "California", 94305, "650-725-1627"));
		library.authors.add(new Author("Y. Daniel Liang", "11935 Abercorn Street", "Savannah", "Georgia", 314191997, "912-344-3264"));
		library.authors.add(new Author("Ray Murphy", "University Road", "Galway", "County Galway, Ireland", 904018, "353-91-493081"));
		library.authors.add(new Author("Walter Isaacson", "789 Street", "New Orleans", "Louisiana", 70112, "504-789-0123"));

		// create instances of books
		library.books.add(new Book("The Lost Symbol", "Mystery & Thrillers", "$10", 0));
		library.books.add(new Book("Angels & Demons", "Mystery & Thrillers", "$16", 0));
		library.books.add(new Book("The Da Vinci Code", "Mystery & Thrillers", "$10", 0));
		library.books.add(new Book("Deception Point", "Mystery & Thrillers", "$16", 0));
		library.books.add(new Book("Digital Fortress", "Mystery & Thrillers", "$9", 0));
		library.books.add(new Book("The 7 Habits of Highly Effective People", "Business & Investing", "$16", 1));
		library.books.add(new Book("The 8th Habit: From Effectiveness to Greatness", "Business & Investing", "$16", 1));
		library.books.add(new Book("The 3rd Alternative: Solving Life's Most Difficult Problems", "Business & Investing", "$16", 1));
		library.books.add(new Book("What I Wish I Knew When I Was 20", "Business & Investing", "$23", 2));
		library.books.add(new Book("Introduction to Java Programming, Comprehensive", "Computers & Technology", "$129", 3));
		library.books.add(new Book("English Grammar In Use", "Education & Reference", "$36", 4));
		library.books.add(new Book("Steve Jobs", "Biographies & Memoirs", "$30", 5));

		// instantiate a LibraryTest object that invokes libraryGUI() method
		LibraryTest viewer = new LibraryTest();
		viewer.libraryGUI();
	}

	public void libraryGUI() {

		// instantiate a JFrame object
		outputFrame = new JFrame();
		outputFrame.setSize(1100,300);
		outputFrame.setTitle("LibraryTest");
		outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		container = outputFrame.getContentPane();
		container.setLayout( new FlowLayout() );

		// instantiate a JPanel object
		panel1 = new JPanel();

		// instantiate a JLabel object, add it to container and panel
		label1 = new JLabel( "Title :" );
		container.add( label1 );
		panel1.add(label1);

		textField1 = new JTextField( "", 10 );
		container.add( textField1 );
		panel1.add(textField1);
		//handler is the actionPerformed() below.
		textField1.addActionListener( this );

		button1 = new JButton( "Search on Title" );
		container.add( button1 );
		panel1.add(button1);
		button1.addActionListener( this );

		outputFrame.add(panel1);

		panel2 = new JPanel();

		label2 = new JLabel( "Genre :" );
		container.add( label2 );
		panel2.add(label2);

		textField2 = new JTextField( "", 10 );
		container.add( textField2 );
		panel2.add(textField2);
		textField2.addActionListener( this );

		button2 = new JButton( "Search on Genre" );
		container.add( button2 );
		panel2.add(button2);
		button2.addActionListener( this );

		outputFrame.add(panel2);

		panel3 = new JPanel();

		label3 = new JLabel( "Author Index :" );
		container.add( label3 );
		panel3.add(label3);

		textField3 = new JTextField( "", 2 );
		container.add( textField3 );
		panel3.add(textField3);
		textField3.addActionListener( this );

		button3 = new JButton( "Search on author index" );
		container.add( button3 );
		panel3.add(button3);
		button3.addActionListener( this );

		outputFrame.add(panel3);

		//create a textarea, attach a scrollbar, add to container.
		textArea = new JTextArea(10,75);
		container.add( new JScrollPane(textArea));

		outputFrame.setVisible(true);
	}

	// event handler for JButton, JTextField events.
	public void actionPerformed( ActionEvent event ) {

		//access the text
		String queryTitle = textField1.getText();
		String queryGenre = textField2.getText();
		String queryAuthorIndex = textField3.getText();

		if ( event.getSource() == button1 ) {
			textArea.setText(""); // change the text
			if (!queryTitle.equals("")) {
				Book resultTitle = this.library.searchTitle(queryTitle);
				if (resultTitle == null) {
					textArea.append("\"" + queryTitle + "\" is not found in the library.\n");
				}
				else {
					textArea.append(resultTitle.toString() + "\n");
				}
			}
			else {
				textArea.append("Enter a book title.\n");
			}
		}
		else if ( event.getSource() == button2 ) {
			textArea.setText(""); // change the text
			if (!queryGenre.equals("")) {
				ArrayList<Book> resultGenre = this.library.searchGenre(queryGenre);
				if (resultGenre == null) {
					textArea.append("\"" + queryGenre + "\" is not found in the library.\n");
				}
				else {
					textArea.append(resultGenre.toString() + "\n");
				}
			}
			else {
				textArea.append("Enter a book genre.\n");
			}
		}
		else if ( event.getSource() == button3 ) {
			textArea.setText(""); // change the text
			if (!queryAuthorIndex.equals("")) {
				int queryAuthorIndexInt = Integer.valueOf(queryAuthorIndex);
				ArrayList<Book> resultAuthorIndex = this.library.searchAuthorIndex(queryAuthorIndexInt);
				if (resultAuthorIndex == null) {
					textArea.append("\"" + queryAuthorIndex + "\" is not found in the library.\n");
				}
				else {
					textArea.append(resultAuthorIndex.toString() + "\n");
				}
			}
			else {
				textArea.append("Enter an author index.\n");
			}
		}
	}

}