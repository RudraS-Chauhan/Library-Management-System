import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileManager
{
    LibraryFunctions lib;
    FileManager(LibraryFunctions lib)
    {
        this.lib = lib;
    }

    void saveBooksToFile()
    {
        try
        {
            FileWriter fw = new FileWriter("books.txt");
            for(int i =0;i<lib.bookCount; i++)
            {
                fw.write(lib.books[i][0] + ","    // ID
                        + lib.books[i][1] + ","    // Title
                        + lib.books[i][2] + ","    // Author
                        + lib.books[i][3] + ","    // Qty
                        + lib.books[i][4] + "\n"); // Status
            }
            fw.close();
            System.out.println("✅ Books saved to books.txt");
        
        } catch (Exception e)
        {
        System.out.println("❌ Error saving books: " + e.getMessage());
                    
        }
    }

    void loadBooksFromFile(LibraryFunctions library) throws FileNotFoundException
    {
        File file = new File("books.txt");
        if (!file.exists()) {
            System.out.println("No existing book records found.");
            return;
        }
        Scanner fileReader = new Scanner(file);
        
        while (fileReader.hasNextLine()) {
        String line = fileReader.nextLine();
        String[] parts = line.split(",");

        for (int j = 0; j < parts.length; j++) {
            library.books[library.bookCount][j] = parts[j];
        }
        library.bookCount++;
    }
    fileReader.close();
    System.out.println("✅ Books loaded from books.txt");
    }
}