public class Loan {
    private int bookId;
    private int memberId;
    private String outDate;
    private String dueDate;
    private String inDate;

    public Loan(int bookId, int memberId, String outDate, String dueDate) {
        this.bookId = bookId; this.memberId = memberId;
        this.outDate = outDate; this.dueDate = dueDate;
    }

    public int getBookId() { return bookId; }
    public int getMemberId() { return memberId; }

    public void checkIn(String d) { this.inDate = d; }

    @Override
    public String toString() {
        return "loan{b=" + bookId + ", m=" + memberId + ", out=" + outDate + ", due=" + dueDate + (inDate==null? ", in=—" : ", in=" + inDate) + "}";
    }
}