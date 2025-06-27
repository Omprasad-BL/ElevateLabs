import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadNotes {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("notes.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading.");
            e.printStackTrace();
        }
    }
}
