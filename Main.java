public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        System.out.println("---- SETUP ----");
        lib.addBook(new Book(101, "Riyadh History", "Alzahrani", "history"));
        lib.addBook(new Book(102, "Saudi Law Basics", "Alharbi", "law"));
        lib.addBook(new Book(103, "Smart Cities KSA", "Alqahtani", "tech"));

        Member m1 = new Member(1, "Noura");
        Member m2 = new Member(2, "Faisal");
        lib.addMember(m1);
        lib.addMember(m2);
        System.out.println("added 3 books and 2 members");

        System.out.println();
        System.out.println("---- POLYMORPHISM CHECK ----");
        User u = new Member(9, "Abdullah");
        System.out.println(u.show());
        if (u instanceof Member) System.out.println("user is member");

        System.out.println();
        System.out.println("---- BORROW & RETURN----");
        System.out.println(lib.borrow(1, 102));
        System.out.println(lib.borrow(2, 102));
        System.out.println(lib.giveBack(1, 102));
        System.out.println(lib.borrow(2, 102));

        System.out.println();
        System.out.println("---- SEARCH----");
        System.out.println("search by title 'law': " + lib.search("law").size());
        System.out.println("search by author 'alzahrani': " + lib.search("alzahrani", "author").size());

        System.out.println();
        System.out.println("---- LISTS----");
        System.out.println("books:");
        lib.printBooksFast();
        System.out.println("books (iter):");
        lib.printBooksIter();
        System.out.println("members: " + lib.listMembers().size());
        System.out.println("loans: " + lib.listLoans().size());

        System.out.println();
        System.out.println("---- DONE ----");
    }
}