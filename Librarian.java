public class Librarian extends User {
    public Librarian(int id, String name) { super(id, name); }

    @Override
    public String show() {
        return "librarian " + id + " - " + name;
    }
}