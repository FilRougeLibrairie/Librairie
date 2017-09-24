package ui.jfPurchase;

import ClassObjet.Author;
import ClassObjet.Book;
import SQLS.AuthorDAO;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */
public class BookTableItem {

    Book book;
    String title;
    String subtitle;
    Author Author;
    String authorName;
    int stock;
    float priceHT;

    public BookTableItem(Book book) {
        this.book = book;
        this.title = book.getBooTitle();
        this.subtitle = book.getBooSubtitle();
        this.authorName = findAutorName();
        this.priceHT = book.getBooPriceHT();
        this.stock = book.getBooQuantity();
    }

    private String findAutorName() {
        AuthorDAO authorDAO = new AuthorDAO();
        Vector<Author> authorList = new Vector<Author>();
        StringBuilder authorName = new StringBuilder();
        authorList = authorDAO.findAuthorByBook(book.getBooIsbn13());
        for (Author author : authorList) {
            authorName.append(author.getAutFirstName())
                    .append(" ")
                    .append(author.getAutLastName())
                    .append(" ");
        }
        return authorName.toString();
    }

    public Vector getVector() {
        Vector v = new Vector();
        v.add(this);
        v.add(this.title);
        v.add(this.subtitle);
        v.add(this.authorName);
        v.add(this.stock);
        v.add(this.priceHT);
        return v;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Author getAuthor() {
        return Author;
    }

    public void setAuthor(Author Author) {
        this.Author = Author;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPriceHT() {
        return priceHT;
    }

    public void setPriceHT(float priceHT) {
        this.priceHT = priceHT;
    }

    @Override
    public String toString() {
        return this.book.getBooIsbn13();
    }

}
