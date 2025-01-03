import java.util.Scanner;

class Library {
    private String[] books;
    private boolean[] isBorrowed;
    private int bookCount;
    private final int MAX_BOOKS = 10;

    public Library() {
        books = new String[MAX_BOOKS];
        isBorrowed = new boolean[MAX_BOOKS];
        bookCount = 0;
    }

    public void addBook(String bookTitle) {
        if(bookCount < MAX_BOOKS) {
            books[bookCount] = bookTitle;
            isBorrowed[bookCount] = false;
            bookCount++;
            System.out.println("Book added :" + bookTitle);
        }
        else {
            System.out.println("Library is full.");
        }
    }

    public String searchBook(String bookTitle) {
        for(int i = 0; i < bookCount; i++){
            if(books[i].equalsIgnoreCase(bookTitle)) {
                if(isBorrowed[i]) {
                    return "Book is already borrowed.";
                }
                else {
                    return "Book is available.";
                }
            }
        }
        return "Book not found.";
    }

    public void borrowBook(String bookTitle) {
        for(int i = 0; i < bookCount; i++) {
            if(books[i].equalsIgnoreCase(bookTitle)) {
                if(isBorrowed[i]) {
                    System.out.println("Book is already borrowed.");
                }
                else {
                    System.out.println("Book borrowed successfully.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String bookTitle) {
        for(int i = 0; i < bookCount; i++) {
            if(books[i].equalsIgnoreCase(bookTitle)) {
                if(isBorrowed[i]) {
                    isBorrowed[i] = false;
                    System.out.println("Book returned successfully.");
                }
                else {
                    System.out.println("Book is not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void printMenu() {
        System.out.println("\n Library Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Search Book");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. Exit");
        System.out.println("Enter your choice :");
    }
}

public class LibraryManagementSystem{
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running) {
            library.printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("Enter the book title :");
                    String bookTitle = scanner.nextLine();
                    library.addBook(bookTitle);
                break;
                case 2:
                    System.out.println("Enter the book title :");
                    String searchBookTitle = scanner.nextLine();
                    System.out.println(library.searchBook(searchBookTitle));
                break;
                case 3:
                    System.out.println("Enter the Borrow book title :");
                    String borrowBookTitle = scanner.nextLine();
                    library.borrowBook(borrowBookTitle);
                break;
                case 4:
                    System.out.println("Enter the Return book title :");
                    String returnBookTitle = scanner.nextLine();
                    library.returnBook(returnBookTitle);
                break;
                case 5:
                    running = false;
                    System.out.println("Programe was ended !");
                break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}

