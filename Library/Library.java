import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Books in Library:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void issueBook(String title, User user) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (!b.isIssued()) {
                    b.issue();
                    System.out.println(user.getName() + " issued: " + title);
                    return;
                } else {
                    System.out.println("Sorry, the book is already issued.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String title, User user) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (b.isIssued()) {
                    b.returnBook();
                    System.out.println(user.getName() + " returned: " + title);
                    return;
                } else {
                    System.out.println("Book wasn't issued.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }
}
