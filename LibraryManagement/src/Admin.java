public class Admin extends User implements LibraryOperations {
    private String password;

    public Admin(String name, String id, String password) {
        super(name, id);
        this.password = password;
    }

    public boolean authenticate(String username, String password) {
        return this.name.equals(username) && this.password.equals(password);
    }

    @Override
    public boolean issueLoan(Library library, Book book, Member member) {
        return library.issueLoan(book, member);
    }

    @Override
    public boolean returnLoan(Library library, Book book, Member member) {
        return library.returnLoan(book, member);
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
    }

    public void registerMember(Library library, Member member) {
        library.registerMember(member);
    }

    @Override
    public void displayDetails() {
        System.out.println("Admin Name: " + name);
        System.out.println("Admin ID: " + id);
    }
}
