public class Book {

    private final String title;
    private final String author;
    private final Long isbn;
    private final int numberOfCopies;

    public Book(String title, String author, Long isbn, int numberOfCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.numberOfCopies = numberOfCopies;
    }

    public String getTitle() {

        return title;
    }

    public String getAuthor() {

        return author;
    }

    public Long getIsbn() {

        return isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn=" + isbn +
                ", numberOfCopies=" + numberOfCopies +
                '}';
    }
}
