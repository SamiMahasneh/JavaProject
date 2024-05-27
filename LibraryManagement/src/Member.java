import java.util.ArrayList;
import java.util.List;

public class Member extends User {
    private List<Book> borrowedBooks;

    public Member(String name, String id) {
        super(name, id);
        this.borrowedBooks = new ArrayList<>();
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrow();
            borrowedBooks.add(book);
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Member Name: " + name);
        System.out.println("Member ID: " + id);
    }

    
}
