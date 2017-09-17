package ui.jfCustomer;

import ClassObjet.Book;
import ClassObjet.Review;
import ClassObjet.StatusDisplay;
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
    private int status;
    private String statusName;

    public ReviewTableItem(Review review) {
        this.book = review.getBook();
        this.review = review;
        this.date = review.getRevDate().toString();
        this.isbn = review.getBooIsbn13();
        this.bookTitle = book.getBooTitle();
        this.comment = review.getRevComment();
        this.score = review.getRevNote().toString();
        this.status = review.getRevStatus();
    }

    public Vector getVector() {
        Vector v = new Vector();
        v.add(this);
        v.add(this.statusName);
        v.add(this.score);
        return v;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return date;
    }
}
