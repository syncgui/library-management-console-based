import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        int option = 0;

        Library library = new Library();
        Scanner input = new Scanner(System.in);

        while (option != 5) {
            System.out.println("""
                    1. Add book
                    2. Delete book
                    3. Search book by title
                    4. Search book by author
                    5. Close the program""");
            System.out.print("Select a option by typing the corresponding number: ");
            option = input.nextInt();

            switch (option) {
                case 1 -> { // add book
                    System.out.print("Type the book title: ");
                    input.nextLine();
                    String bookTitle = input.nextLine();
                    System.out.print("Type the author name: ");
                    String authorName = input.nextLine();
                    System.out.print("Type the number of copies available: ");
                    int numerOfCopies = input.nextInt();
                    System.out.print("Type the ISBN number: ");
                    long isbnNumber = input.nextLong();
                    while (library.checkIfISBNExists(isbnNumber)) {
                        System.out.print("Type the ISBN number: ");
                        isbnNumber = input.nextLong();
                    }
                    Book book = new Book(bookTitle, authorName, isbnNumber, numerOfCopies);
                    library.addBook(book);
                }
                case 2 -> { // delete book
                    System.out.print("Type the ISBN number of the book you want to delete: ");
                    Long isbnToDelete = input.nextLong();
                    library.deleteBook(isbnToDelete);
                }
                case 3 -> { // search by title
                    System.out.print("Type the title of the book you want to search: ");
                    input.nextLine();
                    String titleToSearch = input.nextLine();

                    List<Book> books = library.searchByTitle(titleToSearch);

                    if (books.isEmpty()) {
                        System.out.println("No books found!");
                    } else {
                        for (Book book : books) {
                            System.out.println(book);
                        }
                    }
//                    library.searchByTitle(titleToSearch).forEach(System.out::println);
                }
                case 4 -> { // search by author
                    System.out.print("Type the title of the author you want to search: ");
                    input.nextLine();
                    String authorToSearch = input.nextLine();

                    List<Book> books = library.searchByAuthor(authorToSearch);

                    if (books.isEmpty()) {
                        System.out.println("No authors found!");
                    } else {
                        for (Book book : books) {
                            System.out.println(book);
                        }
                    }
                }
            }
        }
        System.out.println("Closing the program...");
        input.close();
    }
}
