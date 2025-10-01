import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
public class LibraryFunctions
{
        Scanner sc = new Scanner(System.in);
        String[][] books = new String[100][5];
        int bookCount = 0;
        String[][] issued = new String[100][5];
        int issuedCount = 0;


    void addBook() {
        System.out.print("Enter Book ID: ");
        String id = sc.nextLine();
        id = id.toUpperCase();

        for (int i = 0; i < bookCount; i++) {
            if (books[i][0].equalsIgnoreCase(id)) {
                System.out.println("❌ Book with this ID already exists. Use Update instead.");
                return;
            }
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Quantity: ");
        String qty = sc.nextLine();

        books[bookCount][0] = id;
        books[bookCount][1] = title;
        books[bookCount][2] = author;
        books[bookCount][3] = qty;
        books[bookCount][4] = "Available";

        bookCount++;

        System.out.println("✅ Book added successfully!");
    }

    void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        String id = sc.nextLine();
        id = id.toUpperCase();

        boolean found = false;

        for (int i = 0; i < bookCount; i++) {
            if (books[i][0].equalsIgnoreCase(id)) {
                found = true;
                int qty = Integer.parseInt(books[i][3]);

                if (qty > 0) {
                    System.out.print("Enter Student Name: ");
                    String student = sc.nextLine();

    
                    books[i][3] = String.valueOf(qty - 1);
                    if (qty - 1 == 0) books[i][4] = "Not Available";

                    LocalDate issueDate = LocalDate.now();
                    LocalDate dueDate = issueDate.plusDays(14);

                    issued[issuedCount][0] = id;
                    issued[issuedCount][1] = books[i][1];
                    issued[issuedCount][2] = student;
                    issued[issuedCount][3] = issueDate.toString();
                    issued[issuedCount][4] = dueDate.toString();
                    issuedCount++;

                    System.out.println("📖 Book '" + books[i][1] + "' issued to " + student);
                    generateReceipt(id, student, "ISSUED");
                } else {
                    System.out.println("❌ Book is out of stock.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Book ID not found in library.");
        }
    }

    void returnBook()
    {
        System.out.println("Enter Book ID to return: ");
        String id = sc.nextLine();
        id = id.toUpperCase();

        for(int i = 0; i < issuedCount; i++) {
            if(issued[i][0].equalsIgnoreCase(id))
             {
                for(int j = 0; j < bookCount; j++) 
                {
                    if(books[j][0].equalsIgnoreCase(id)) 
                    {
                        int qty = Integer.parseInt(books[j][3]);
                        books[j][3] = String.valueOf(qty + 1);
                        break;
                    }
                }

                String student = issued[i][2];
                generateReceipt(id, student, "RETURNED");

                for(int k = i; k < issuedCount - 1; k++) {
                    issued[k] = issued[k + 1];
                }
                issuedCount--;

                System.out.println("✅ Book returned successfully.");
                return;
            }
        }
        
    }
    void showIssuedBooks()
    {
        if(issuedCount == 0) {
            System.out.println("No books are currently issued.");
            return;
        }
        System.out.println("Show issued books by:");
        System.out.println("1. All");
        System.out.println("2. By Borrower");
        System.out.println("3. Overdue only");
        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
            for(int j=0; j<issuedCount; j++) {
                System.out.println("Book ID: " + issued[j][0]);
                System.out.println("Title: " + issued[j][1]);
                System.out.println("Borrower: " + issued[j][2]);
                System.out.println("Issue Date: " + issued[j][3]);
                System.out.println("Due Date: " + issued[j][4]);
                System.out.println("---------------------------");
            }
            break;
            case 2: 
            System.out.print("Enter Borrower Name: ");
            String borrower = sc.nextLine();
            for(int j=0; j<issuedCount; j++) {
                boolean found = false;
                if(issued[j][2].equalsIgnoreCase(borrower)) {
                    found = true;
                    System.out.println("Book ID: " + issued[j][0]);
                    System.out.println("Title: " + issued[j][1]);
                    System.out.println("Borrower: " + issued[j][2]);
                    System.out.println("Issue Date: " + issued[j][3]);
                    System.out.println("Due Date: " + issued[j][4]);
                    System.out.println("---------------------------");
                }
                if(!found) System.out.println("No books found for " + borrower);
            }
            break;
            case 3:
            boolean overdueFound = false;
            for (int j = 0; j < issuedCount; j++) {
                LocalDate dueDate = LocalDate.parse(issued[j][4]);
                if (LocalDate.now().isAfter(dueDate)) {
                    overdueFound = true;
                    System.out.println("Book ID: " + issued[j][0]);
                    System.out.println("Title: " + issued[j][1]);
                    System.out.println("Borrower: " + issued[j][2]);
                    System.out.println("Issue Date: " + issued[j][3]);
                    System.out.println("Due Date: " + issued[j][4]);
                    System.out.println("---------------------------");
                            }
                }
                if (!overdueFound) {
                    System.out.println("No overdue books.");
                }
                break;


            default: System.out.println("Invalid choice."); break;
        }


    }
    void searchBook()
    {
        System.out.println("Search by:");
        System.out.println("1. Book ID");
        System.out.println("2. Title");
        System.out.println("3. Author");
        System.out.print("Enter choice: ");
        int foundCount = 0;

        int ch = sc.nextInt();
        sc.nextLine();
        switch(ch)
        {
            case 1:
            System.out.println("Enter Book ID: ");
            String id = sc.nextLine();
            id = id.toUpperCase();
            
            for(int i=0; i<bookCount; i++)
            {
                if(books[i][0].equalsIgnoreCase(id))
                {
                    System.out.println("Book found:");
                    System.out.println("ID: " + books[i][0]);
                    System.out.println("Title: " + books[i][1]);
                    System.out.println("Author: " + books[i][2]);
                    System.out.println("Quantity: " + books[i][3]);
                    System.out.println("Status: " + books[i][4]);
                    return;
                }
            }
            foundCount++;
            if(foundCount == 0) 
            System.out.println("Book not found.");
            break;


            case 2:
            System.out.println("Enter Title of the book: ");
            String title = sc.nextLine().toLowerCase();
            for(int i=0; i<bookCount; i++)
            {
                if(books[i][1].toLowerCase().contains(title))
                {
                    System.out.println("Book found:");
                    System.out.println("ID: " + books[i][0]);
                    System.out.println("Title: " + books[i][1]);
                    System.out.println("Author: " + books[i][2]);
                    System.out.println("Quantity: " + books[i][3]);
                    System.out.println("Status: " + books[i][4]);
                    System.out.println("---------------------------");
                    foundCount++;
                }
            }
            break;

            case 3:
            System.out.println("Enter Author name: ");
            String author = sc.nextLine().toLowerCase();
            for(int i =0; i<bookCount; i++)
            {
                if(books[i][2].toLowerCase().contains(author))
                {
                    System.out.println("Book found:");
                    System.out.println("ID: " + books[i][0]);
                    System.out.println("Title: " + books[i][1]);
                    System.out.println("Author: " + books[i][2]);
                    System.out.println("Quantity: " + books[i][3]);
                    System.out.println("Status: " + books[i][4]);
                    System.out.println("---------------------------");
                    foundCount++;
                }
            }
            break;

        }
    }
    void showAvailableBooks() 
    {
        if (bookCount == 0) {
            System.out.println("No books in library.");
            return;
        }

        System.out.println("Show Available books:");
        System.out.println("1. Unsorted List");
        System.out.println("2. Sorted by Title");
        System.out.println("3. Summary Only");
        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(sc.nextLine());

        int distinctAvailableTitles = 0;
        int totalAvailableCopies = 0;

        int[] idx = new int[bookCount];
        for (int i = 0; i < bookCount; i++) {
            idx[i] = i;
        }

        if (choice == 2) {
            for (int j = 0; j < bookCount - 1; j++) {
                for (int k = j + 1; k < bookCount; k++) {
                    if (books[idx[j]][1].compareToIgnoreCase(books[idx[k]][1]) > 0) {
                        int temp = idx[j];
                        idx[j] = idx[k];
                        idx[k] = temp;
                    }
                }
            }
        }

        for (int n = 0; n < bookCount; n++) {
            int i = (choice == 2) ? idx[n] : n; 

            int qty = Integer.parseInt(books[i][3]);
            if (qty > 0) {
                distinctAvailableTitles++;
                totalAvailableCopies += qty;

                if (choice != 3) { 
                    System.out.println("ID: " + books[i][0]);
                    System.out.println("Title: " + books[i][1]);
                    System.out.println("Author: " + books[i][2]);
                    System.out.println("Quantity: " + books[i][3]);
                    System.out.println("Status: " + books[i][4]);

                    int issuedForThisBook = 0;
                    for (int m = 0; m < issuedCount; m++) {
                        if (issued[m][0].equals(books[i][0])) {
                            issuedForThisBook++;
                        }
                    }
                    System.out.println("Currently issued: " + issuedForThisBook);
                    System.out.println("---------------------------");
                    }
                }
            }
            System.out.println("Total available titles: " + distinctAvailableTitles);
            System.out.println("Total copies available: " + totalAvailableCopies);
        }

    void generateReceipt(String bookId, String student, String action)
    {
            String title = "";
            String author = "";
            for (int i = 0; i < bookCount; i++) {
                if (books[i][0].equalsIgnoreCase(bookId)) {
                    title = books[i][1];
                    author = books[i][2];
                    break;
                }
            }

            String fileName = "receipts/" + action + "_" + student + "_" + System.currentTimeMillis() + ".txt";
            LocalDate today = LocalDate.now();
            LocalDate dueDate = null;

            if (action.equals("ISSUED")) {
                dueDate = today.plusDays(14);
            } else if (action.equals("RETURNED")) {
                for (int j = 0; j < issuedCount; j++) {
                    if (issued[j][0].equalsIgnoreCase(bookId) && issued[j][2].equalsIgnoreCase(student)) {
                        dueDate = LocalDate.parse(issued[j][4]);
                        break;
                    }
                }
            }

            int fine = 0;
            if (action.equals("RETURNED") && dueDate != null && today.isAfter(dueDate)) {
                long daysLate = today.toEpochDay() - dueDate.toEpochDay();
                fine = (int) daysLate * 5;
            }

            StringBuilder receipt = new StringBuilder();
            receipt.append("=========================================\n");
            receipt.append("           LIBRARY TRANSACTION SLIP      \n");
            receipt.append("=========================================\n\n");
            receipt.append("Action      : ").append(action).append("\n");
            receipt.append("Book ID     : ").append(bookId).append("\n");
            receipt.append("Title       : ").append(title).append("\n");
            receipt.append("Author      : ").append(author).append("\n");
            receipt.append("Student     : ").append(student).append("\n");
            receipt.append("Date        : ").append(today).append("\n");

            if (dueDate != null) {
                receipt.append("Due Date    : ").append(dueDate).append("\n");
            }

            if (fine > 0) {
                receipt.append("Fine        : ₹").append(fine)
                    .append(" (").append(fine / 5).append(" days late)\n");
            } else if (action.equals("RETURNED")) {
                receipt.append("Fine        : None\n");
            }

            receipt.append("\n=========================================\n");
            receipt.append("   Thank you for using the library!      \n");
            receipt.append("=========================================\n");

            try {
                File dir = new File("receipts");
                if (!dir.exists()) dir.mkdir();

                FileWriter fw = new FileWriter(fileName);
                fw.write(receipt.toString());
                fw.close();

                System.out.println("✅ Receipt generated: " + fileName);
            } catch (Exception e) {
                System.out.println("❌ Error writing receipt: " + e.getMessage());
            }
        }


    void exportIssuedReport()
    {
        if(issuedCount == 0) {
            System.out.println("No books are currently issued.");
            return;
        }
        try {
            String fileName = "issued_report" + System.currentTimeMillis() + "issued_report.txt";
            java.io.FileWriter fw = new java.io.FileWriter(fileName);
            fw.write("=== ISSUED BOOKS REPORT ===\n\n");
            for(int i = 0; i<issuedCount; i++)
            {
                fw.write("Book ID: " + issued[i][0] + "\n");   
                fw.write("Title: " + issued[i][1] + "\n");
                fw.write("Borrower: " + issued[i][2] + "\n");
                fw.write("Issue Date: " + issued[i][3] + "\n");
                fw.write("Due Date: " + issued[i][4] + "\n");
                fw.write("---------------------------\n");
            }
            fw.close();
            System.out.println("✅ Issued report exported: " + fileName);
        } catch (Exception e) {
            System.out.println("❌ Error exporting report: " + e.getMessage());
        }
    }
}