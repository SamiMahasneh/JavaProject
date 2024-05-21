import java.util.Date;

public class Loan {
    private Book book;
    private Member member;
    private Date issueDate;
    private Date returnDate;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.issueDate = new Date();
        this.returnDate = null;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void issue() {
        member.borrowBook(book);
    }

    public void returnBook() {
        member.returnBook(book);
        this.returnDate = new Date();
    }
}
