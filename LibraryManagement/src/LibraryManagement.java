import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        Admin admin = new Admin("admin", "password");
        Scanner scanner = new Scanner(System.in);

        Book book1 = new Book("Book Title 1", "Author 1", "ISBN001", 5);
        Book book2 = new Book("Book Title 2", "Author 2", "ISBN002", 3);
        admin.addBook(library, book1);
        admin.addBook(library, book2);

        Member member1 = new Member("Member 1", "MEM001");
        Member member2 = new Member("Member 2", "MEM002");
        admin.registerMember(library, member1);
        admin.registerMember(library, member2);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Issue a book");
            System.out.println("2. Return a book");
            System.out.println("3. Add a book");
            System.out.println("4. Register a member");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN of the book to issue: ");
                    String isbnToIssue = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String memberIdToIssue = scanner.nextLine();
                    Book bookToIssue = library.findBook(isbnToIssue);
                    Member memberToIssue = library.findMember(memberIdToIssue);
                    if (admin.issueLoan(library, bookToIssue, memberToIssue)) {
                        System.out.println("Book issued.");
                    } else {
                        System.out.println("Failed to issue book.");
                    }
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to return: ");
                    String isbnToReturn = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String memberIdToReturn = scanner.nextLine();
                    Book bookToReturn = library.findBook(isbnToReturn);
                    Member memberToReturn = library.findMember(memberIdToReturn);
                    if (admin.returnLoan(library, bookToReturn, memberToReturn)) {
                        System.out.println("Book returned.");
                    } else {
                        System.out.println("Failed to return book.");
                    }
                    break;
                case 3:
                    System.out.print("Enter title of the book: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author of the book: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN of the book: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter number of copies: ");
                    int copies = scanner.nextInt();
                    scanner.nextLine();  
                    Book newBook = new Book(title, author, isbn, copies);
                    admin.addBook(library, newBook);
                    System.out.println("Book added.");
                    break;
                case 4:
                    System.out.print("Enter name of the member: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();
                    Member newMember = new Member(name, memberId);
                    admin.registerMember(library, newMember);
                    System.out.println("Member registered.");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
