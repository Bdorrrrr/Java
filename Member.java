import java.util.ArrayList;

public class Member extends User {
    private ArrayList<Integer> loanIds = new ArrayList<>();

    public Member(int id, String name) { super(id, name); }

    public void addLoan(int bid) { loanIds.add(bid); }
    public void rmLoan(int bid) { loanIds.remove(Integer.valueOf(bid)); }
    public ArrayList<Integer> getLoans() { return loanIds; }

    @Override
    public String show() {
        return "member " + id + " - " + name + " | loans: " + loanIds.size();
    }
}