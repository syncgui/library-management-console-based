

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
        System.out.println("Book successfully added");
    }

    public void deleteBook(Long isbn) {
        if (bookList.containsKey(isbn)) {
            bookList.remove(isbn);
            System.out.println("Book successfully deleted");
        } else {
            System.out.println("Invalid ISBN Number");
        }
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            } else {
                System.out.println("Entered title does not match");
            }
        }
        return result;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> restult = new ArrayList<>();
        for (Book book : bookList.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                restult.add(book);
            } else {
                System.out.println("Entered auhtor does not match");
            }
        }
    return restult;
    }
}
