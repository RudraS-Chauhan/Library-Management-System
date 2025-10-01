import java.util.*;
public class Main {    
    Scanner sc = new Scanner(System.in);
    int choice;

    LibraryFunctions library = new LibraryFunctions();
    FileManager fileManager = new FileManager(library);

    void handleChoice(int choice) 
    {
        switch (choice) 
        {
            case 1:
                library.addBook();
                fileManager.saveBooksToFile();
                break;
            case 2:
                library.showAvailableBooks();
                break;
            case 3:
                library.issueBook();
                fileManager.saveBooksToFile();
                break;
            case 4:
                library.returnBook();
                fileManager.saveBooksToFile();
                break;
            case 5:
                library.searchBook();
                break;
            case 6:
                library.showIssuedBooks();
                break;
            case 7:
                library.exportIssuedReport();
                break;
            case 8:
                library.showAvailableBooks();
                break;
            case 9:
                System.out.println("Exiting Library... Goodbye!");
                System.exit(0);
            default:
                System.out.println("❌ Invalid choice. Please try again.");
        }
    }

    void run() {
        while (true) {
            printMenu();
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // clear leftover newline
                handleChoice(choice);
            } else {
                System.out.println("❌ Please enter a valid number.");
                sc.nextLine(); // discard invalid input
            }
        }
    }

    void printMenu() {
        System.out.println("\n=== LIBRARY MANAGEMENT MENU ===");
        System.out.println("1. Add Book");
        System.out.println("2. View All Books");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. Search Book by Title/Author/ID");
        System.out.println("6. Show Issued Books");
        System.out.println("7. Export Issued Report");
        System.out.println("8. Sort Books by Title");
        System.out.println("9. Exit");
        System.out.print("Enter choice: ");
    }

    public static void main(String[] args) 
    {
        Main app = new Main();
        try {
            app.fileManager.loadBooksFromFile(app.library);
        } 
        catch (Exception e) 
        {
            System.out.println("⚠️ Could not load books: " + e.getMessage());
        }
        app.run();
}

}