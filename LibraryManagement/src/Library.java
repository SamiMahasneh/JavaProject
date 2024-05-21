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

    public void issueLoan(Book book, Member member) {
        if (book != null && member != null && book.isAvailable()) {
            Loan loan = new Loan(book, member);
            loans.add(loan);
            loan.issue();
        }
    }

    public void returnLoan(Book book, Member member) {
        if (book != null && member != null) {
            Loan loan = new Loan(book, member);  // Simplified for example; typically you would find and update the existing loan
            loans.remove(loan);
            loan.returnBook();
        }
    }
}
