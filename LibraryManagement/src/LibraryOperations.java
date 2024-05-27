public interface LibraryOperations {
    boolean issueLoan(Library library, Book book, Member member);
    boolean returnLoan(Library library, Book book, Member member);
}
