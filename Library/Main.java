public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some books
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("Clean Code", "Robert Martin"));

        // Create a user
        User user1 = new User("Alice");

        library.displayBooks();

        // Issue a book
        library.issueBook("1984", user1);

        library.displayBooks();

        // Return a book
        library.returnBook("1984", user1);

        library.displayBooks();
    }
}
