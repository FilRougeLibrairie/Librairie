package ui.jfPurchase;

import ClassObjet.OrderLine;
import java.util.Vector;
import utils.PriceCalculation;

/**
 *
 * @author ggarvanese
 */


public class OrderLineTableItem {
    
    private OrderLine orderLine;
    private String isbn;
    private String bookTitle;
    private int quantity;
    private float totalPriceHT;
    private float unitPriceHT;
    private float vat;
    private float priceTTC;

    public OrderLineTableItem(OrderLine orderLine) {
        this.orderLine = orderLine;
        this.isbn = orderLine.getBooIsbn13().getBooIsbn13();
        this.bookTitle = orderLine.getBooIsbn13().getBooTitle();
        this.quantity = orderLine.getOrdLineQuantity();
        this.unitPriceHT = PriceCalculation.roundedPrice(orderLine.getOrdBookPriceHT());
        this.totalPriceHT = this.unitPriceHT * quantity;
        this.vat = orderLine.getOrdBookVAT();
        this.priceTTC = PriceCalculation.roundedPrice(PriceCalculation.calculatePriceTTC(unitPriceHT, vat) * quantity);
    }
    
        public Vector getVector() {
        Vector v = new Vector();
        v.add(this);
        v.add(bookTitle);
        v.add(quantity);
        v.add(unitPriceHT);
        v.add(vat);
        v.add(totalPriceHT);
        v.add(priceTTC);
        return v;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPriceHT() {
        return unitPriceHT;
    }

    public void setPriceHT(float priceHT) {
        this.unitPriceHT = priceHT;
    }

    public float getVat() {
        return vat;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    public float getPriceTTC() {
        return priceTTC;
    }

    public void setPriceTTC(float priceTTC) {
        this.priceTTC = priceTTC;
    }

    @Override
    public String toString() {
        return isbn;
    }
    
}
