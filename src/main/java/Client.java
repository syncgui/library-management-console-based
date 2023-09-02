import java.util.List;
import java.util.Scanner;

public class Client {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Library library = new Library();

        int option = 0;

        while (option != 5) {
            System.out.println("""
                    1. Add book
                    2. Delete book
                    3. Search book by title
                    4. Search book by author
                    5. Close the program""");
            System.out.print("Select a option by typing the corresponding number: ");

            option = askForIntegerChoice();

            switch (option) {
                case 1 -> { // add book
                    System.out.print("Type the book title: ");
                    String bookTitle = input.nextLine();
                    System.out.print("Type the author name: ");
                    String authorName = input.nextLine();
                    System.out.print("Type the number of copies available: ");
                    int numberOfCopies = askForIntegerChoice();
                    System.out.print("Type the ISBN number: ");
                    long isbnNumber = askForLongChoice();
                    while (library.checkIfISBNExists(isbnNumber)) {
                        System.out.print("ISBN already exists, type a new ISBN number: ");
                        isbnNumber = askForLongChoice();
                    }
                    Book book = new Book(bookTitle, authorName, isbnNumber, numberOfCopies);
                    library.addBook(book);
                }
                case 2 -> { // delete book
                    System.out.print("Type the ISBN number of the book you want to delete: ");
                    Long isbnToDelete = askForLongChoice();
                    while (!library.checkIfISBNExists(isbnToDelete)) {
                        System.out.print("ISBN already exists, type a new ISBN number: ");
                        isbnToDelete = askForLongChoice();
                    }
                    library.deleteBook(isbnToDelete);
                }
                case 3 -> { // search by title
                    System.out.print("Type the title of the book you want to search: ");
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

    private static int askForIntegerChoice() {
        try {
            String number = input.nextLine();
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.print("Invalid input. Please enter a number: ");
            return askForIntegerChoice();
        }
    }

    private static Long askForLongChoice() {
        try {
            String number = input.nextLine();
            return Long.parseLong(number);
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.print("Invalid input. Please enter a number: ");
            return askForLongChoice();
        }
    }
}
