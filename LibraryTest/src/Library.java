import java.util.ArrayList;
import java.util.Iterator;

public class Library {

	// instantiate an Author and a Book objects
	public ArrayList<Author> authors;
	public ArrayList<Book> books;

	//constructor
	Library() {
		authors = new ArrayList<Author>();
		books = new ArrayList<Book>();
	}

	private int indexBook;
	private Book b;
	private ArrayList<Book> array = new ArrayList<Book>();

	// search on book title
	// queryTitle is from user input.
	public Book searchTitle(String queryTitle) {
		Iterator<Book> it = books.iterator();
		while (it.hasNext()) {
			b = it.next();
			indexBook = b.title.indexOf(queryTitle);
			if (indexBook != -1){
				return b;
			}
		}
		return null;
	}

	// search on book genre
	// queryGenre is from user input.
	public ArrayList<Book> searchGenre(String queryGenre) {
		array.clear();
		Iterator<Book> it = books.iterator();
		while (it.hasNext()) {
			b = it.next();
			indexBook = b.genre.indexOf(queryGenre);
			if (indexBook != -1){
				array.add(b);
			}
		}
		if (!array.isEmpty()) {
			return array;
		} else {
			return null;
		}
	}

	// search on author index
	// queryAuthorIndex is from user input.
	public ArrayList<Book> searchAuthorIndex(int queryAuthorIndex) {
		array.clear();
		Iterator<Book> it = books.iterator();
		while (it.hasNext()) {
			b = it.next();
			if (queryAuthorIndex == b.authorIndex){
				array.add(b);
			}
		}
		if (!array.isEmpty()) {
			return array;
		} else {
			return null;
		}
	}
}