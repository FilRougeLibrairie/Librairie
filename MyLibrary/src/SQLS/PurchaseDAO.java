package SQLS;

import ClassObjet.Address;
import ClassObjet.Customer;
import ClassObjet.Purchase;
import ClassObjet.ShippingCost;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */
public class PurchaseDAO extends DAO {

    private final String TABLE = "Purchase";

    private final String ID = PurchaseNames.ID;
    private final String CUSTOMER_ID = PurchaseNames.CUSTOMER_ID;
    private final String SHIPPING_COST = PurchaseNames.SHIPPING_COST;
    private final String ADDRESS_DELIVERY = PurchaseNames.ADDRESS_DELIVERY;
    private final String ADDRESS_INVOICE = PurchaseNames.ADDRESS_INVOICE;
    private final String IP = PurchaseNames.IP;
    private final String SHIPPING_DATE = PurchaseNames.SHIPPING_DATE;
    private final String SHIPPING_NUMBER = PurchaseNames.SHIPPING_NUMBER;

    private String COLUMNS_CREATE = CUSTOMER_ID + ", " + SHIPPING_COST + ", "
            + ADDRESS_DELIVERY + ", " + ADDRESS_INVOICE + ", " + IP + ", " + SHIPPING_DATE + ", "
            + SHIPPING_NUMBER;

    Vector<Purchase> purList;
    Purchase pur;
    Customer cus;
    ShippingCost shipCost;
    Address addrDelivery;
    Address addrInvoice;

    public PurchaseDAO() {
        super();
    }

    @Override
    public void create(Object obj) {
        Purchase pur = (Purchase) obj;
        String query = "IF NOT EXISTS (SELECT * FROM " + TABLE + " WHERE " + ID + " = '" + pur.getPurId() + "')"
                + "INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setInt(1, pur.getCusId().getCusID());
            pstmt.setInt(2, pur.getShippingCostId().getShipId());
            pstmt.setInt(3, pur.getAddDeliveryId().getAddId());
            pstmt.setInt(4, pur.getAddInvoiceId().getAddId());
            pstmt.setString(5, pur.getPurIP());
            pstmt.setString(6, pur.getShippingDate());
            pstmt.setInt(7, pur.getShippingNumber());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            ex.getStackTrace();
        }
    }

    @Override
    public void delete(Object obj) {
        int purId = ((Purchase) obj).getPurId();
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + purId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Object obj) {
        pur = (Purchase) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(CUSTOMER_ID).append(" = ?, ");
        query.append(SHIPPING_COST).append(" = ?, ");
        query.append(ADDRESS_DELIVERY).append(" = ?, ");
        query.append(ADDRESS_INVOICE).append(" = ?, ");
        query.append(IP).append(" = ?, ");
        query.append(SHIPPING_DATE).append(" = ?, ");
        query.append(SHIPPING_NUMBER).append(" = ? ");

        query.append("WHERE " + ID + " = '")
                .append(pur.getPurIP())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setInt(1, pur.getCusId().getCusID());
            pstmt.setInt(2, pur.getShippingCostId().getShipId());
            pstmt.setInt(3, pur.getAddDeliveryId().getAddId());
            pstmt.setInt(4, pur.getAddInvoiceId().getAddId());
            pstmt.setString(5, pur.getPurIP());
            pstmt.setString(6, pur.getShippingDate());
            pstmt.setInt(7, pur.getShippingNumber());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            ex.printStackTrace();

        }
    }

    @Override
    public Vector findAll() {
        purList = new Vector<Purchase>();
        pur = null;
        cus = null;
        shipCost = null;
        addrDelivery = null;
        addrInvoice = null;

        String query = "SELECT * FROM " + TABLE;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    pur = new Purchase();
                    cus = new Customer();
                    shipCost = new ShippingCost();
                    addrDelivery = new Address();
                    addrInvoice = new Address();

                    pur.setPurId(rs.getInt(ID));
                    cus.setCusID(rs.getInt(CUSTOMER_ID));
                    shipCost.setShipId(rs.getInt(SHIPPING_COST));
                    pur.setShippingCostId(shipCost);
                    addrDelivery.setAddId(rs.getInt(ADDRESS_DELIVERY));
                    pur.setAddDeliveryId(addrDelivery);
                    addrInvoice.setAddId(rs.getInt(ADDRESS_INVOICE));
                    pur.setAddInvoiceId(addrInvoice);
                    pur.setPurIP(rs.getString(IP));
                    pur.setShippingDate(rs.getString(SHIPPING_DATE));
                    pur.setShippingNumber(rs.getInt(SHIPPING_NUMBER));

                    purList.add(pur);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return purList;
    }

    @Override
    public Purchase findById(int id) {
        pur = null;
        cus = null;
        shipCost = null;
        addrDelivery = null;
        addrInvoice = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + id + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    pur = new Purchase();
                    cus = new Customer();
                    shipCost = new ShippingCost();
                    addrDelivery = new Address();
                    addrInvoice = new Address();

                    cus.setCusID(rs.getInt(CUSTOMER_ID));
                    shipCost.setShipId(rs.getInt(SHIPPING_COST));
                    pur.setShippingCostId(shipCost);
                    addrDelivery.setAddId(rs.getInt(ADDRESS_DELIVERY));
                    pur.setAddDeliveryId(addrDelivery);
                    addrInvoice.setAddId(rs.getInt(ADDRESS_INVOICE));
                    pur.setAddInvoiceId(addrInvoice);
                    pur.setPurIP(rs.getString(IP));
                    pur.setShippingDate(rs.getString(SHIPPING_DATE));
                    pur.setShippingNumber(rs.getInt(SHIPPING_NUMBER));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return pur;
    }

    @Override
    public Object findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector findByCriteria(String criteria, String term) {
        purList = new Vector<Purchase>();
        pur = null;
        cus = null;
        shipCost = null;
        addrDelivery = null;
        addrInvoice = null;

        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(criteria)
                .append(" = ")
                .append("'" + term + "'");

        System.out.println();

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    pur = new Purchase();
                    cus = new Customer();
                    shipCost = new ShippingCost();
                    addrDelivery = new Address();
                    addrInvoice = new Address();

                    cus.setCusID(rs.getInt(CUSTOMER_ID));
                    shipCost.setShipId(rs.getInt(SHIPPING_COST));
                    pur.setShippingCostId(shipCost);
                    addrDelivery.setAddId(rs.getInt(ADDRESS_DELIVERY));
                    pur.setAddDeliveryId(addrDelivery);
                    addrInvoice.setAddId(rs.getInt(ADDRESS_INVOICE));
                    pur.setAddInvoiceId(addrInvoice);
                    pur.setPurIP(rs.getString(IP));
                    pur.setShippingDate(rs.getString(SHIPPING_DATE));
                    pur.setShippingNumber(rs.getInt(SHIPPING_NUMBER));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();

        }
        return purList;
    }

}
