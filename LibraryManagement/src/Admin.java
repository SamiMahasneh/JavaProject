public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void issueLoan(Library library, Book book, Member member) {
        library.issueLoan(book, member);
    }

    public void returnLoan(Library library, Book book, Member member) {
        library.returnLoan(book, member);
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
    }

    public void registerMember(Library library, Member member) {
        library.registerMember(member);
    }
}
