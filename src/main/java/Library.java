import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {

    public Library() {

        this.bookList = new HashMap<>();
    }

    HashMap<Long, Book> bookList;

    public void addBook(Book book) {
        bookList.put(book.getIsbn(), book);
        System.out.println("Book successfully added!");
    }

    public boolean checkIfISBNExists(Long ISBN) {
        return bookList.containsKey(ISBN);
    }

    public void deleteBook(Long isbn) {
        if (bookList.containsKey(isbn)) {
            bookList.remove(isbn);
            System.out.println("Book successfully deleted!");
        } else {
            System.out.println("Invalid ISBN Number!");
        }
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }
}
