package ui.jfPurchase;

import ClassObjet.Offer;
import ClassObjet.OrderLine;
import SQLS.OfferDAO;
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
    private int stock;
    private float totalPriceHT;
    private float unitPriceHT;
    private float discount;
    private float vat;
    private float totalPriceTTC;
    private int orderLineId;

    public OrderLineTableItem(OrderLine orderLine) {
        this.orderLine = orderLine;
        this.orderLineId = orderLine.getOrdLineId();
        this.isbn = orderLine.getBooIsbn13().getBooIsbn13();
        this.bookTitle = orderLine.getBooIsbn13().getBooTitle();
        this.quantity = orderLine.getOrdLineQuantity();
        this.stock = orderLine.getBooIsbn13().getBooQuantity();
        if (orderLine.getBooIsbn13().getCurrentOffer() != null) {
            this.discount = orderLine.getBooIsbn13().getCurrentOffer().getOffDiscount();
        } else {
            this.discount = 0;
        }
        this.unitPriceHT = orderLine.getOrdBookPriceHT();
        
        Float unitPriceAfterDiscount = PriceCalculation.calculateDiscount(this.unitPriceHT, this.discount);
        this.totalPriceHT = PriceCalculation.getRoundedPrice(unitPriceAfterDiscount * quantity);
        this.vat = orderLine.getOrdBookVAT();
        this.totalPriceTTC = PriceCalculation.getRoundedPrice(PriceCalculation.calculatePriceTTC(unitPriceAfterDiscount, vat) * quantity);
    }

    public Vector getVector() {
        Vector v = new Vector();
        v.add(this);
        v.add(bookTitle);
        v.add(stock);
        v.add(quantity);
        v.add(unitPriceHT);
        v.add(discount);
        v.add(vat);
        v.add(totalPriceHT);
        v.add(totalPriceTTC);
        return v;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    public float getTotalPriceHT() {
        return totalPriceHT;
    }

    public void setTotalPriceHT(float totalPriceHT) {
        this.totalPriceHT = totalPriceHT;
    }

    public float getUnitPriceHT() {
        return unitPriceHT;
    }

    public void setUnitPriceHT(float unitPriceHT) {
        this.unitPriceHT = unitPriceHT;
    }

    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
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
        return totalPriceTTC;
    }

    public void setPriceTTC(float priceTTC) {
        this.totalPriceTTC = priceTTC;
    }

    @Override
    public String toString() {
        return isbn;
    }

}
