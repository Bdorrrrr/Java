public class Book {
    private int id;
    private String title;
    private String author;
    private String cat;
    private boolean out;

    public Book(int id, String title, String author, String cat) {
        this.id = id; this.title = title; this.author = author; this.cat = cat;
        this.out = false;}
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCat() { return cat; }
    public boolean isOut() { return out; }
    public void setTitle(String t) { this.title = t; }
    public void setAuthor(String a) { this.author = a; }
    public void setCat(String c) { this.cat = c; }
    public void markOut() { this.out = true; }
    public void markIn() { this.out = false; }
    @Override
    public String toString() {
        return "#" + id + " - " + title + " (" + author + ") [" + (out ? "out" : "in") + "]";}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        return id == ((Book)o).id;}
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}