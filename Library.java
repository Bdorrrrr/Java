import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public void addBook(Book b) { books.add(b); }
    public void addMember(Member m) { members.add(m); }

    public List<Book> search(String txt) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(txt.toLowerCase())) res.add(b);
        }
        return res;
    }

    public List<Book> search(String txt, String by) {
        ArrayList<Book> res = new ArrayList<>();
        String key = by==null? "" : by.toLowerCase();
        for (Book b : books) {
            if ("author".equals(key)) {
                if (b.getAuthor().toLowerCase().contains(txt.toLowerCase())) res.add(b);
            } else if ("cat".equals(key)) {
                if (b.getCat().toLowerCase().contains(txt.toLowerCase())) res.add(b);
            } else {
                if (b.getTitle().toLowerCase().contains(txt.toLowerCase())) res.add(b);
            }
        }
        return res;
    }

    public String borrow(int mid, int bid) {
        Book b = findBookById(bid);
        Member m = findMemberById(mid);
        if (b == null) return "book not found";
        if (m == null) return "member not found";
        if (b.isOut()) return "sorry, book is out";
        b.markOut();
        m.addLoan(bid);
        loans.add(new Loan(bid, mid, today(), plusDays(14)));
        return "borrowed book " + bid + " to member " + mid;
    }

    public String giveBack(int mid, int bid) {
        Book b = findBookById(bid);
        Member m = findMemberById(mid);
        if (b == null || m == null) return "invalid data";
        if (!b.isOut()) return "book is not out";
        b.markIn();
        m.rmLoan(bid);
        for (Loan ln : loans) {
            if (ln.getBookId() == bid && ln.getMemberId() == mid) { ln.checkIn(today()); break; }
        }
        return "returned book " + bid + " from member " + mid;
    }

    public List<Book> listBooks() { return new ArrayList<>(books); }
    public List<Member> listMembers() { return new ArrayList<>(members); }
    public List<Loan> listLoans() { return new ArrayList<>(loans); }

    public void printBooksFast() {
        for (Book b : books) System.out.println(b.toString());
    }

    public void printBooksIter() {
        ListIterator<Book> it = books.listIterator();
        while (it.hasNext()) System.out.println(it.next());
    }

    private Book findBookById(int id) {
        for (Book b : books) if (b.getId() == id) return b;
        return null;
    }

    private Member findMemberById(int id) {
        for (Member m : members) if (m.getId() == id) return m;
        return null;
    }

    private String today() { return "2025-11-05"; }
    private String plusDays(int d) { return "2025-11-19"; }
}