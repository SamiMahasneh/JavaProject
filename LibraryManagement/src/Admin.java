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

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public boolean issueLoan(Library library, Book book, Member member) {
        return library.issueLoan(book, member);
    }

    public boolean returnLoan(Library library, Book book, Member member) {
        return library.returnLoan(book, member);
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
    }

    public void registerMember(Library library, Member member) {
        library.registerMember(member);
    }
}
