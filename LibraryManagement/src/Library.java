import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private List<Loan> loans;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public Book findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Member findMember(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    public boolean issueLoan(Book book, Member member) {
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }
        if (member == null) {
            System.out.println("Member not found.");
            return false;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is not available.");
            return false;
        }
        Loan loan = new Loan(book, member);
        loans.add(loan);
        loan.issue();
        return true;
    }

    public boolean returnLoan(Book book, Member member) {
        if (book == null || member == null) {
            System.out.println("Book or Member not found.");
            return false;
        }
        Loan foundLoan = null;
        for (Loan loan : loans) {
            if (loan.getBook().equals(book) && loan.getMember().equals(member)) {
                foundLoan = loan;
                break;
            }
        }
        if (foundLoan != null) {
            loans.remove(foundLoan);
            foundLoan.returnBook();
            return true;
        } else {
            System.out.println("Loan record not found.");
            return false;
        }
    }
}
