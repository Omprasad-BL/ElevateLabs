import java.io.FileWriter;
import java.io.IOException;

public class WriteNotes {
    public static void main(String[] args) {
        String note = "This is a sample note.\n";
        try {
            // If you want to append, use: new FileWriter("notes.txt", true)
            FileWriter writer = new FileWriter("notes.txt");
            writer.write(note);
            writer.close();
            System.out.println("Note written to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing.");
            e.printStackTrace();
        }
    }
}
