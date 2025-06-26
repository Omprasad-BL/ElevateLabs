import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // Preload a few books (optional)
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("Clean Code", "Robert Martin"));

        System.out.print("Enter your name: ");
        String username = sc.nextLine();
        User user = new User(username);

        int choice;
        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. View all books");
            System.out.println("2. Add a book");
            System.out.println("3. Issue a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("Book added successfully.");
                    break;

                case 3:
                    System.out.print("Enter the title of the book to issue: ");
                    String issueTitle = sc.nextLine();
                    library.issueBook(issueTitle, user);
                    break;

                case 4:
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = sc.nextLine();
                    library.returnBook(returnTitle, user);
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
