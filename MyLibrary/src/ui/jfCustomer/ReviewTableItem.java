package ui.jfCustomer;

import ClassObjet.Book;
import ClassObjet.Review;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */
public class ReviewTableItem {

    private Review review;
    private String date;
    private String isbn;
    private String bookTitle;
    private String comment;
    private String score;
    private Book book;

    public ReviewTableItem(Review review) {
        this.book = review.getBook();
        this.review = review;
        this.date = review.getRevDate();
        this.isbn = review.getBooIsbn13();
        this.bookTitle = book.getBooTitle();
        this.comment = review.getRevComment();
        this.score = review.getRevNote().toString();
        System.out.println("BOOK TITILE : " + this.bookTitle);
    }
    
     public Vector getVector() {
        Vector v = new Vector();
        v.add(this);
        v.add(this.isbn);
        v.add(this.bookTitle);
        v.add(this.comment);
        v.add(this.score);
        return v;
    }

    @Override
    public String toString() {
        return date;
    } 
}
