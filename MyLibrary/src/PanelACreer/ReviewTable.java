
package PanelACreer;

import ClassObjet.Review;
import java.util.Vector;


public class ReviewTable {
    
    private Review review;
    private int reference;
    private String date;
    private int  booIsbn13;

    public ReviewTable(Review review, int reference, String date, int booIsbn13) {
        this.review = review;
        this.reference = reference;
        this.date = date;
        this.booIsbn13 = booIsbn13;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBooIsbn13() {
        return booIsbn13;
    }

    public void setBooIsbn13(int booIsbn13) {
        this.booIsbn13 = booIsbn13;
    }
    
 @Override
    public String toString() {
        return String.valueOf(reference);
    }
    

    public Vector getVector() {
        Vector v = new Vector();
        v.add(this);
        return v;
    }
}
